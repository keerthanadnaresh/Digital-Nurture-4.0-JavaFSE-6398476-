

class CustomComputer {
    
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String graphicsCard;


    private CustomComputer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    
    public void showConfiguration() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + graphicsCard);
    }

    
    public static class ComputerBuilder {
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;

        public ComputerBuilder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public CustomComputer build() {
            return new CustomComputer(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        
        CustomComputer basicPC = new CustomComputer.ComputerBuilder()
            .setCPU("Intel i3")
            .setRAM("8GB")
            .setStorage("256GB SSD")
            .build();

        basicPC.showConfiguration();

        System.out.println();

        
        CustomComputer gamingPC = new CustomComputer.ComputerBuilder()
            .setCPU("AMD Ryzen 9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4080")
            .build();

        gamingPC.showConfiguration();
    }
}
