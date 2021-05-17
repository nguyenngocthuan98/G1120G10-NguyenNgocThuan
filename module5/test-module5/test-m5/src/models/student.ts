export class Student {
  private id: number;
  private name: string;
  private nameGroup: number;
  private topic: string;
  private teacher: number;
  private email: string;
  private phone: string;

  constructor(id: number, name: string, nameGroup: number, topic: string, teacher: number, email: string, phone: string) {
    this.id = id;
    this.name = name;
    this.nameGroup = nameGroup;
    this.topic = topic;
    this.teacher = teacher;
    this.email = email;
    this.phone = phone;
  }
}
