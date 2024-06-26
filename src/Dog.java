

/**
 * Fill this in once I know what my task is
 * @param args
 */
public class Dog {
        private String name;
        private Long microchip;
        private String breed;
        private String sex;
        private boolean deSexed;
        private int age;

        public Dog(String name, Long mircochip, String breed, String sex, boolean deSexed, int age) {
            this.name = name;
            this.microchip = mircochip;
            this.breed = breed;
            this.sex = sex;
            this.deSexed = deSexed;
            this.age = age;
        }

        public String getName(){
                return name;
        }

        public Long getMicrochip(){
                return microchip;
        }

        public String getBreed(){
                return breed;
        }

        public String getSex(){
                return sex;
        }

        public boolean isDeSexed() {
                return deSexed;
        }

        public int age() {
                return age;
        }

        public void setDesexed(boolean deSexed) {
                this.deSexed = deSexed;
        }
}
