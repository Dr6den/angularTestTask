export class Task {

    constructor(public name?: string,
                public startDate?: Date,
                public endDate?: Date,
                public executors?: Array<string>) {}
}
