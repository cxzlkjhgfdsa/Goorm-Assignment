class Github {
    constructor() {
        this.client_id = "ea6684be937da3c622f9";
        this.client_secret = "8302f3e7157ea250a46d0103af7634b00c84fdcf";
        this.repos_count = 5;
        this.repos_sort = "created:asc";
    }

    async getUser(user) {
        const profileResponse = await fetch(`https://api.github.com/users/${user}`, {
            headers: {
                Authorization: "token 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",
            },
        });

        const repoResponse = await fetch(
            `https://api.github.com/users/${user}/repos?per_page=${this.repos_count}&sort=${this.repos_sort}
            `,
            {
                headers: {
                    Authorization: "token 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",
                },
            }
        );

        const profile = await profileResponse.json();
        const repos = await repoResponse.json();

        console.log(profile);
        console.log(repos);

        return { profile, repos };
    }
}
