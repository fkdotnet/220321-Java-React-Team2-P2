//the types file in our store is going to store all the possible types (objects) we will need

//declaring some types with default values as interfaces
export interface IUser {
    id: number;
    username: string;
    password: string;
}

export interface IRegister {
    id: number;
}

export interface INote {
    id: number;
    title: string;
    content: string; 
}

export interface IUserData {
    id: number;
    email: string;
    roles: string[];
    tokenType: string;
    accessToken: string;
}

//AppState object that will store one of each interface.
//note the type keyword... it's like calling something an object in java
export type AppState = {
    user: IUser, //one empty user object
    register: IRegister,
    save: boolean,
    notes: INote[] 
}
//separating values by commas here, because it's an object not an interface