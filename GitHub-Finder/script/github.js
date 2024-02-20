class Github {
    constructor() {
        this.client_id = "client_id";
        this.client_secret = "client_secret";
        this.repos_count = 5;
        this.repos_sort = "created:asc";
    }

    async getUser(user) {
        const profileResponse = await fetch(
            `https://api.github.com/users/${user}
            ?client_id=${this.client_id}&client_secret=${this.client_secret}
        `,
            {
                headers: {
                    Authorization: "token personal_Token",
                },
            }
        );

        const repoResponse = await fetch(
            `https://api.github.com/users/${user}/repos?per_page=${this.repos_count}&sort=${this.repos_sort}
            `,
            {
                headers: {
                    Authorization: "token personal_Token",
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
