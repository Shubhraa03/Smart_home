import java.util.Scanner;

// SmartDevice interface representing common functionalities of smart devices
interface Smart_Device {
    void turnOn();
    void turnOff();
    boolean isOn();
}

// SmartLightBulb class implementing the SmartDevice interface
class SmartLightBulb implements Smart_Device {
    private boolean isOn;

    public SmartLightBulb() {
        this.isOn = false; // Initially, the light bulb is off
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Light bulb is now turned on.");
        } else {
            System.out.println("Light bulb is already on.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Light bulb is now turned off.");
        } else {
            System.out.println("Light bulb is already off.");
        }
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}

class SmartFan implements Smart_Device {
    private boolean isOn;

    public SmartFan() {
        this.isOn = false; // Initially, the fan is off
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Fan is now turned on.");
        } else {
            System.out.println("Fan is already on.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Fan is now turned off.");
        } else {
            System.out.println("Fan is already off.");
        }
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}

// SmartThermostat class implementing the SmartDevice interface
class SmartThermostat implements Smart_Device {
    private boolean isOn;
    private int temperature;

    public SmartThermostat() {
        this.isOn = false; // Initially, the thermostat is off
        this.temperature = 20; // Default temperature setting
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Thermostat is now turned on.");
        } else {
            System.out.println("Thermostat is already on.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Thermostat is now turned off.");
        } else {
            System.out.println("Thermostat is already off.");
        }
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void setTemperature(int temperature) {
        if (isOn) {
            this.temperature = temperature;
            System.out.println("Temperature set to " + temperature + "°C.");
        } else {
            System.out.println("Thermostat is off. Please turn it on first.");
        }
    }

    public int getTemperature() {
        return temperature;
    }
}

// SmartLock class implementing the SmartDevice interface
class SmartLock implements Smart_Device {
    private boolean isLocked;

    public SmartLock() {
        this.isLocked = false; // Initially, the lock is unlocked
    }

    @Override
    public void turnOn() {
        if (!isLocked) {
            isLocked = true;
            System.out.println("Lock is now locked.");
        } else {
            System.out.println("Lock is already locked.");
        }
    }

    @Override
    public void turnOff() {
        if (isLocked) {
            isLocked = false;
            System.out.println("Lock is now unlocked.");
        } else {
            System.out.println("Lock is already unlocked.");
        }
    }

    @Override
    public boolean isOn() {
        return isLocked;
    }
}

// Main class to simulate smart home automation system
class Main {
    public static void main(String[] args) {
        // Create instances of smart devices
        SmartLightBulb smartBulb = new SmartLightBulb();
        SmartFan smartfan = new SmartFan();
        SmartThermostat smartThermostat = new SmartThermostat();
        SmartLock smartLock = new SmartLock();

        Scanner scanner = new Scanner(System.in);
        int choice;

        // Menu for user interaction
        do {
            System.out.println("\nSmart Home Automation System");
            System.out.println("1. Turn On Light Bulb");
            System.out.println("2. Turn Off Light Bulb");
            System.out.println("3. Turn On Fan");
            System.out.println("4. Turn Off Fan");
            System.out.println("5. Turn On Thermostat");
            System.out.println("6. Turn Off Thermostat");
            System.out.println("7. Set Thermostat Temperature");
            System.out.println("8. Turn On Lock");
            System.out.println("9. Turn Off Lock");
            System.out.println("10. View Status of All Devices");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    smartBulb.turnOn();
                    break;
                case 2:
                    smartBulb.turnOff();
                    break;
                case 3:
                    smartfan.turnOn();
                    break;
                case 4:
                    smartfan.turnOff();
                    break;
                case 5:
                    smartThermostat.turnOn();
                    break;
                case 6:
                    smartThermostat.turnOff();
                    break;
                case 7:
                    System.out.print("Enter temperature (in °C): ");
                    int temperature = scanner.nextInt();
                    smartThermostat.setTemperature(temperature);
                    break;
                case 8:
                    smartLock.turnOn();
                    break;
                case 9:
                    smartLock.turnOff();
                    break;
                case 10:
                    System.out.println("\nStatus of All Devices:");
                    System.out.println("Light Bulb: " + (smartBulb.isOn() ? "On" : "Off"));
                    System.out.println("Thermostat: " + (smartThermostat.isOn() ? "On" : "Off"));
                    System.out.println("Temperature: " + smartThermostat.getTemperature() + "°C");
                    System.out.println("Lock: " + (smartLock.isOn() ? "Locked" : "Unlocked"));
                    break;
                case 11:
                    System.out.println("Exiting...");
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
