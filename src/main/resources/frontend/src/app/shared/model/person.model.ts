export interface Person {
  personalId: string;
  firstName: string;
  lastName: string;
  dateOfBirth: string;
  gender: Gender;
}

enum Gender {
  MALE,
  FEMALE,
}
