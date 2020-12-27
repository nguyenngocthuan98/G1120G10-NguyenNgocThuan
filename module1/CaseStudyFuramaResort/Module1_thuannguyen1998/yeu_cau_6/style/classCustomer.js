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
