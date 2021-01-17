package bai11_dsa_stack_queue.bai_tap.demerging_queue;

class Employees {
    public String name;
    public boolean gender;
    public String dateOfBirth;

    public Employees(String name, boolean gender, String dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

//    public String displayGender(boolean gender) {
//        String display = "";
//        if (gender) {
//            display = "NAM";
//        } else {
//            display = "NU";
//        }
//        return display;
//    }

    @Override
    public String toString() {
        return "name: " + this.getName() + ", gender: " + this.isGender() + ", dateOfBirth: " + getDateOfBirth();
    }
}




