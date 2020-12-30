class Customer {
    constructor(
        fullName, indentifyNumber, dayOfBirth, email, address, typeOfCustomer, discount, includePeople, dayRents, typeService, typeRoom
    )
        {
            this.fullName = fullName;
            this.indentifyNumber = indentifyNumber;
            this.dayOfBirth = dayOfBirth;
            this.email = email;
            this.address = address;
            this.typeOfCustomer = typeOfCustomer;
            this.discount = discount;
            this.includePeople = includePeople;
            this.dayRents = dayRents;
            this.typeService = typeService;
            this.typeRoom = typeRoom;
        }
    
    getFullName() {
        return this.fullName;
    }
    setFullName(fullName) {
        this.fullName = fullName;
    }

    getIndentifyNumber() {
        return this.indentifyNumber;
    }
    setIndentifyNumber(indentifyNumber) {
        this.indentifyNumber = indentifyNumber;
    }

    getDayOfBirth() {
        return this.dayOfBirth;
    }
    setDayOfBirth(dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    getEmail() {
        return this.email;
    }
    setEmail(email) {
        this.email = email;
    }

    getAddress() {
        return this.address;
    }
    setAddress(address) {
        this.address = address;
    }

    getTypeOfCustomer() {
        return this.typeOfCustomer;
    }
    setTypeOfCustomer(typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    getDiscount() {
        return this.discount;
    }
    setDiscount(discount) {
        this.discount = discount;
    }

    getIncludePeople() {
        return this.includePeople;
    }
    setIncludePeople(includePeople) {
        this.includePeople = includePeople;
    }

    getDayRents() {
        return this.dayRents;
    }
    setDayRents(dayRents) {
        this.dayRents = dayRents;
    }

    getTypeService() {
        return this.typeService;
    }
    setTypeService(typeService) {
        this.typeService = typeService;
    }

    getTypeRoom() {
        return this.typeRoom;
    }
    setTypeRoom(typeRoom) {
        this.typeRoom = typeRoom;
    }

    roomCharge() {
        let money;
        switch (this.typeService) {
            case "Villa":
                money = 500;
                break;
            case "House":
                money = 300;
            break;
            case "Room":
                money = 100;
                break;
            default:
                money = 0;
                break;
        }
        return (this.dayRents * money * (1 - this.discount/100)).toFixed(2);
    }
}

class Employee {
    constructor(
        employeeFullName, employeeIdentify, employeeBirthday, employeePhone, employeeEmail, level, position
    )
    {
        this.employeeFullName = employeeFullName;
        this.employeeIdentify = employeeIdentify;
        this.employeeBirthday = employeeBirthday;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.level = level;
        this.position = position;
    }

    getemployeeFullName() {
        return this.employeeFullName;
    }

    setemployeeFullName(employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    getEmployeeBirthday() {
        return this.employeeBirthday;
    }

    setEmployeeBirthday(employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    getemployeeIdentify() {
        return this.employeeIdentify;
    }

    setemployeeIdentify(employeeIdentify) {
        this.employeeIdentify = employeeIdentify;
    }

    getEmployeePhone() {
        return this.employeePhone;
    }

    setEmployeePhone(employeePhone) {
        this.employeePhone = employeePhone;
    }

    getEmployeeEmail() {
        return this.employeeEmail;
    }

    setEmployeeEmail(employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    getLevel() {
        return this.level;
    }

    setLevel(level) {
        this.level = level;
    }

    getPosition() {
        return this.position;
    }

    setPosition(position) {
        this.position = position;
    }

    getDepartment() {
        let department;
        switch (this.position) {
            case "Receptionist":
            case "Service staff":
                department = "Service";
                break;
            case "Specialist":
                department = "Sale-Marketing";
                break;
            case "Supervisor":
                department = "Administration";
                break;
            case "Manager":
            case "Director":
                department = "Management";
                break;
        }
        return department;
    }

    getBenefit() {
        let benefit;
        switch (this.position) {
            case "Receptionist":
            case "Service staff":
                benefit = 100;
                break;
            case "Specialist":
                benefit = 200;
                break;
            case "Supervisor":
                benefit = 300;
                break;
            case "Manager":
                benefit = 400;
                break;
            case "Director":
                benefit = 500;
                break;
        }
        return benefit;
    }

    getBasicSalary() {
        let basicSalary;
        switch (this.position) {
            case "Receptionist":
                basicSalary = 1000;
                break;
            case "Service staff":
                basicSalary = 1200;
                break;
            case "Specialist":
                basicSalary = 2200;
                break;
            case "Supervisor":
                basicSalary = 2500;
                break;
            case "Manager":
                basicSalary = 3000;
                break;
            case "Director":
                basicSalary = 4000;
                break;
        }
        return basicSalary;
    }

    getSalary() {
        this.salary = this.getBenefit() + this.getBasicSalary();
    }
}
