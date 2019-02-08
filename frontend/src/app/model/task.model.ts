export class Task {

    constructor(public name?: string,
                public startDate?: string,
                public endDate?: string,
                public executors?: Array<string>) {}
}
