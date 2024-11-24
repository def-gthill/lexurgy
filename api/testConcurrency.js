// Making sure the API doesn't block itself when it receives long-running requests.

for (let i = 0; i < 11; i++) {
    console.log("Sending SC request");
    fetch(
        "http://localhost:8080/scv1",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                Authorization: "exampleApiKey"
            },
            body: JSON.stringify(
                {
                    changes: "mini-explode:\n(a+ a+)+ b => x",
                    inputWords: new Array(20000).fill("aaaaaaaa")
                }
            )
        }
    ).then(async (response) => {
        console.log(`${new Date().toISOString()}: SC returned ${response.status}`)
    });
}

setTimeout(() => {
    console.log("Sending root request")
    fetch("http://localhost:8080/", {method: "GET"})
        .then(async (response) => {
            console.log(`${new Date().toISOString()}: ${await response.text()}`)
        });
}, 1500)


