import http from "http";

const servers = ["http://localhost:8081", "http://localhost:8082"];
const machineIds = ["a1a1a1", "b2b2b2"];
let current = 0;

const loadBalancer = http.createServer((req, res) => {
    const machineId = req.headers["fly-force-instance-id"];
    let target;
    if (typeof machineId === "string") {
        target = servers[machineIds.indexOf(machineId)];
    } else {
        target = servers[current];
        current = (current + 1) % servers.length;
    }

    const options = new URL(target + req.url);

    const proxy = http.request(
        {
            hostname: options.hostname,
            port: options.port,
            path: options.pathname,
            method: req.method,
            headers: req.headers,
        },
        (proxyRes) => {
            res.writeHead(proxyRes.statusCode, proxyRes.headers);
            proxyRes.pipe(res, { end: true });
        }
    );

    proxy.on("error", (err) => {
        console.error("Error forwarding request:", err.message);
        res.writeHead(500);
        res.end("Internal server error");
    });

    req.pipe(proxy, { end: true });
});

const PORT = 8080;
loadBalancer.listen(PORT, () => {
    console.log(`Load balancer running on port ${PORT}`);
});
