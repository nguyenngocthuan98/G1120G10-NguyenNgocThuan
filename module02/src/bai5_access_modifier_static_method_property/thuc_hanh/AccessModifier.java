package bai5_access_modifier_static_method_property.thuc_hanh;

//This is a demo, be like a test file.
    class A {
        int data = 40;
        protected void msg() {
            System.out.println("Hello java");
        }
    }

    public class AccessModifier {
        public static void main(String args[]) {
            A obj = new A();
            System.out.println(obj.data);
            obj.msg();
        }
    }

