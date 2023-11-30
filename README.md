# AsioTest - BagTripsCalculator Android App

AsioTest is an Android application that was built as part of my interview process to Asio Technologies. This repository is currently public for vieweing purposes and will become private in the near-future.

<img src="https://firebasestorage.googleapis.com/v0/b/the-3p-cups-project.appspot.com/o/images%2Fasio%2Fvideo.gif?alt=media" width="200" alt="A Simple Walkthrough">


## Overview

This Android app demonstrates the BagTripsCalculator algorithm, which efficiently calculates the minimum trips required to dispose of a set of bags.

## Algorithm Description

The BagTripsCalculator algorithm optimally organizes bags into trips to minimize the number of trips needed, considering a maximum weight limit per trip.

## Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/unix14/AsioTest.git
   ```

2. Open the project in Android Studio.

3. Explore the `BagTripsCalculatorImpl` and `BagsListViewModel` to see how the BagTripsCalculator algorithm is integrated.

4. Run the application on an Android emulator or a physical device.

5. Enter number of bags input, and alter the table as you like.

6. Observe the minimum trips needed and the details of each trip in the app.

   ## Screenshots

1. **Step 1**
   
   Enter amount of bags and press **Enter** on **Device Keyboard**
   
   <img src="https://firebasestorage.googleapis.com/v0/b/the-3p-cups-project.appspot.com/o/images%2Fasio%2F1.jpg?alt=media" width="300" alt="Step 1">

3. **Step 2**
   
   Enter Different bags details like index and weight, or use predefined random ones.
   
   <img src="https://firebasestorage.googleapis.com/v0/b/the-3p-cups-project.appspot.com/o/images%2Fasio%2F2.jpg?alt=media" width="300" alt="Step 2">

5. **Step 3**
   
   Press Calculate to see Algorithm results
   
   <img src="https://firebasestorage.googleapis.com/v0/b/the-3p-cups-project.appspot.com/o/images%2Fasio%2F3.jpg?alt=media" width="300" alt="Step 3">



## Example

Below is an example of the BagTripsCalculator algorithm in action:

```java
// Example bags
ArrayList<Bag> bags = new ArrayList<>();
bags.add(new Bag(1, 2.0f));
bags.add(new Bag(2, 3.0f));
bags.add(new Bag(3, 1.01f));
bags.add(new Bag(4, 1.5f));
bags.add(new Bag(5, 1.7f));
bags.add(new Bag(7, 1.3f));
bags.add(new Bag(8, 1.5f));

// Output is
// Minimum Trips Needed: 5
// Trips:
// Trip 1: [Bag #3 (1.01)Kg, Bag #5 (1.7)Kg]
// Trip 2: [Bag #7 (1.3)Kg, Bag #8 (1.5)Kg]
// Trip 3: [Bag #4 (1.5)Kg]
// Trip 4: [Bag #1 (2.0)Kg]
// Trip 5: [Bag #2 (3.0)Kg]

// Calculate trips
BagTripsCalculator calculator = new BagTripsCalculator();
AlgResult result = calculator.calculateBagTrips(bags);

// Display the result
System.out.println("Minimum Trips Needed: " + result.minimumTripsNeeded);
System.out.println("Trips:");
for (int i = 0; i < result.trips.size(); i++) {
    Trip trip = result.trips.get(i);
    System.out.println("Trip " + (i + 1) + ": " + trip.bags);
}
```

