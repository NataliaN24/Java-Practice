Bolt: Vehicle Renting at the Tip of Your Fingers ⚡ 🚗 🚲 🚐
Една набираща популярност услуга е наемът на колела и автомобили за кратко - било то за няколко минути, часа, или пък за цял ден. Естествено, все още съществува възможността и за по-дългосрочен наем на превозно средство за няколко дни или седмици.

Задачата ни този път е да комбинираме двете, упражнявайки знанията си за Records, Sealed Classes и Exceptions. Не всяка от тези концепции е зададена явно, така че мислете внимателно къде какво бихте могли да приложите.

⚠️ Важно:

javaDoc коментарите над дадените методи съдържат очакваната функционалност на задачата.
Всички случаи, които не са експлицитно опоменати там или в условието, няма да бъдат тествани и зависят единствено на вашето въображение и преценка.
Дадената йерархия от класове и методи не е изчерпателна и трябва да бъде доизградена от вас, прилагайки знанията от лекциите до сега.
Пълният списък от exceptions, които се очаква методите да хвърлят са изброени в техните javaDocs. Не всички от тях са изброени в сигнатурата (защо ли?).
RentalService
Платформата за наем на превозни средства, която ще разработим е простичък клас със следната основна структура, която вие трябва да надградите с имплементация и всичко друго, което сметнете за необходимо:

package bg.sofia.uni.fmi.mjt.vehiclerent;

import bg.sofia.uni.fmi.mjt.vehiclerent.driver.Driver;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.InvalidRentingPeriodException;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.VehicleAlreadyRentedException;
import bg.sofia.uni.fmi.mjt.vehiclerent.vehicle.Vehicle;

import java.time.LocalDateTime;

public class RentalService {

    /**
     * Simulates renting of the vehicle. Makes all required validations and then the provided driver "rents" the provided
     * vehicle with start time @startOfRent
     * @throws IllegalArgumentException if any of the passed arguments are null
     * @throws VehicleAlreadyRentedException in case the provided vehicle is already rented
     * @param driver the designated driver of the vehicle
     * @param vehicle the chosen vehicle to be rented
     * @param startOfRent the start time of the rental
     */
    public void rentVehicle(Driver driver, Vehicle vehicle, LocalDateTime startOfRent) {
        throw new UnsupportedOperationException("Dear Student, Remove this Exception and Implement this method");
    }

    /**
     * This method simulates rental return - it includes validation of the arguments that throw the listed exceptions 
     * in case of errors. The method returns the expected total price for the rental - price for the vehicle plus
     * additional tax for the driver, if it is applicable 
     * @param vehicle the rented vehicle
     * @param endOfRent the end time of the rental
     * @return price for the rental
     * @throws IllegalArgumentException in case @endOfRent or @vehicle is null
     * @throws VehicleNotRentedException in case the vehicle is not rented at all
     * @throws InvalidRentingPeriodException in case the endOfRent is before the start of rental, or the vehicle 
     * does not allow the passed period for rental, e.g. Caravans must be rented for at least a day.
     */
    public double returnVehicle(Vehicle vehicle, LocalDateTime endOfRent) throws InvalidRentingPeriodException {
        throw new UnsupportedOperationException("Dear Student, Remove this Exception and Implement this method");
    }
}
Driver
Шофьорите са репрезентирани от проста структура със следния конструктор:

public Driver(AgeGroup group){}
където AgeGroup е възрастовата група на водача, представена от изброен тип AgeGroup със стойности:

JUNIOR
EXPERIENCED
SENIOR
Такса "млад шофьор"
Както забелязвате, returnVehicle методът връща цена за наем, която включва и такса, свързана с възрастта на шофьора. Това е честа практика при компаниите, отдаващи автомобили под наем - смята се, че по-младите и по-възрастните водачи са по-склонни към произшествия и затова те дължат по-голям депозит. В нашия случай, за простота, добавяме еднократна такса, която се начислява към крайната сума за наем вместо депозит.

Таксите са както следва:

JUNIOR: 10
EXPERIENCED: 0
SENIOR: 15
⚠️ Важно: Таксите не се начисляват, ако наетото превозно средство е колело.

Vehicle
Дадена е йерархия от класове, моделираща поддържаните превозни средства: като основен клас имаме Vehicle, който има три наследника - Bicycle, Car и Caravan. Част от класа Vehicle изглежда по следния начин, като трябва да допълните липсващата функционалност.

⚠️ Важно: Методите, член-данните и други детайли на класа не се изчерпват с дадените по-долу.

package bg.sofia.uni.fmi.mjt.vehiclerent.vehicle;

import bg.sofia.uni.fmi.mjt.vehiclerent.driver.Driver;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.InvalidRentingPeriodException;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.VehicleAlreadyRentedException;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.VehicleNotRentedException;

import java.time.LocalDateTime;
import java.util.Objects;

public class Vehicle {
    
    public Vehicle(String id, String model) {
        this.id = id;
        this.model = model;
    }

    /**
     * Simulates rental of the vehicle. The vehicle now is considered rented by the provided driver and the start of the rental is the provided date.
     * @param driver the driver that wants to rent the vehicle.
     * @param startRentTime the start time of the rent
     * @throws VehicleAlreadyRentedException in case the vehicle is already rented by someone else or by the same driver.
     */
    public void rent(Driver driver, LocalDateTime startRentTime) {
        throw new UnsupportedOperationException("Dear Student, Remove this Exception and Implement this method");
    }

    /**
     * Simulates end of rental for the vehicle - it is no longer rented by a driver.
     * @param rentalEnd time of end of rental
     * @throws IllegalArgumentException in case @rentalEnd is null
     * @throws VehicleNotRentedException in case the vehicle is not rented at all
     * @throws InvalidRentingPeriodException in case the rentalEnd is before the currently noted start date of rental or
     * in case the Vehicle does not allow the passed period for rental, e.g. Caravans must be rented for at least a day
     * and the driver tries to return them after an hour.
     */
    public void returnBack(LocalDateTime rentalEnd) throws InvalidRentingPeriodException {
        throw new UnsupportedOperationException("Dear Student, Remove this Exception and Implement this method");
    }

    /**
     * Used to calculate potential rental price without the vehicle to be rented.
     * The calculation is based on the type of the Vehicle (Car/Caravan/Bicycle).
     *
     * @param startOfRent the beginning of the rental
     * @param endOfRent the end of the rental
     * @return potential price for rent
     * @throws InvalidRentingPeriodException in case the vehicle cannot be rented for that period of time or 
     * the period is not valid (end date is before start date)
     */
    public abstract double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent) throws InvalidRentingPeriodException;

}
Видове превозни средства и цена за наем
Услугата ни предоставя възможност за наемане на три вида превозни средства - колела, коли и каравани. Наемът и цената на всеки един от тези типове зависят от няколко условия.

⚠️ Важно: Приемаме, че превозните средства не могат да бъде наети за по-малко от час. Всеки наем под час, струва колкото цял час.

Колела
Колела могат да бъдат наемани за няколко часа или няколко дни, но не повече от седмица (6 дни, 23 часа, 59мин и 59сек; винамавайте да не паднете в overengineering pitfall, проверката е извикване на един метод).
Колелата имат зададени цени за наем за час и за ден. Липсва наем за седмица, т.к. не могат да бъдат наемани за такъв период.
Конструктор:
public Bicycle(String id, String model, double pricePerDay, double pricePerHour){}
Автомобили
Автомобилите имат двигатели (представени чрез изброения тип по-долу), които имат различна такса на ден, която се прибавя към финалната цена за наем.
Автомобилите имат зададени цени за наем за час, ден и седмица.
Автомобилите имат вместимост - брой седалки и стандартна цена за една седалка - 5.
Конструктор:
public Car(String id, String model, FuelType fuelType, int numberOfSeats, double pricePerWeek, double pricePerDay, double pricePerHour) {}
Каравани
Караваните имат двигатели (представени чрез изброения тип по-долу), които имат различна такса на ден, която се прибавя към финалната цена за наем.
Караваните имат вместимост - брой седалки и стандартна цена за една седалка - 5.
Караваните имат допълнителна вместимост - брой легла и стандартна цена за едно легло - 10.
Караваните могат да бъдат наети за минимум един ден (24ч).
Конструктор:
public Caravan(String id, String model, FuelType fuelType, int numberOfSeats, int numberOfBeds, double pricePerWeek, double pricePerDay, double pricePerHour) {}
enum FuelType
Стойностите на типа FuelType и техните дневни такси:

DIESEL: 3
PETROL: 3
HYBRID: 1
ELECTRICITY: 0
HYDROGEN: 0
Пример
import bg.sofia.uni.fmi.mjt.vehiclerent.vehicle.FuelType;

public static void main(String[] args) {
    RentalService rentalService = new RentalService();
    LocalDateTime rentStart = LocalDateTime.of(2024, 10, 10, 0, 0, 0);
    Driver experiencedDriver = new Driver(AgeGroup.EXPERIENCED);
   
    Vehicle electricCar = new Car("1", "Tesla Model 3", FuelType.ELECTRICITY, 4, 1000, 150, 10);
    rentalService.rentVehicle(experiencedDriver, electricCar, rentStart);
    double priceToPay = rentalService.returnVehicle(electricCar, rentStart.plusDays(5)); // 770.0
    
    Vehicle dieselCar = new Car("2", "Toyota Auris", FuelType.DIESEL, 4, 500, 80, 5);
    rentalService.rentVehicle(experiencedDriver, dieselCar, rentStart);
    priceToPay = rentalService.returnVehicle(dieselCar, rentStart.plusDays(5)); // 80*5 + 3*5 + 4*5 = 435.0
}
Структура на пакетите
Спазвайте имената на пакетите на всички по-горе описани класове, интерфейси и конструктори, тъй като в противен случай, решението ви няма да може да бъде автоматично тествано.

src
└─ bg/sofia/uni/fmi/mjt/vehiclerent
    ├─ driver/
    │  ├─ AgeGroup.java
    │  └─ Driver.java
    ├─ exception/
    │  ├─ InvalidRentingPeriodException.java
    │  ├─ VehicleAlreadyRentedException.java
    │  └─ VehicleNotRentedException.java
    ├─ vehicle/
    │  ├─ Bicycle.java
    │  ├─ Car.java
    │  ├─ Caravan.java
    │  ├─ FuelType.java
    │  └─ Vehicle.java   
    └─ RentalService.java
Желателно е да добавите собствени класове и абстракции в съответните пакети.

⚠️ Забележки
Задачата трябва да се реши с помощта на знанията от курса до момента и допълнителните Java APIs, указани в условието.

