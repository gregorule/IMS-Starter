Coverage: 67%
# IMS Starter Project (Gregor Rule)

Project outlines that an application needs to be created using Java that interacts with a managed database using mysql. This application should allow users to create, read, update and delete customers, items and orders as well as calculate the cost of  an order.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Here are the links to install all the required software:
mySQL - https://dev.mysql.com/downloads/windows/installer/8.0.html
Java with Eclipse - https://www.oracle.com/java/technologies/downloads/#java8




### Installing

You need to fork this repository and link it to your Eclipse to use the code. Once you have forked the repo, on Eclipse go to file>Open Project From File System.. and then find where you saved it.

## Using the application

Go to the Runner and run as a Java apllication.

From the options of CUSTOMER, ITEM and ORDERS select which you would like to access. The option STOP closes the application.

After selecting which option you would like to access you can then choose to CREATE, READ, UPDATE or DELETE information for either a customer, item or order. The option RETURN will take you back to the first selection.

From making a further selection you will need to fill in further information as to how you would like to go forward with the program. For example, the name and contact details of the customer or the price and stock of the items.



## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Unit tests ensure that the basic connections between the database and Java are working by putting in test data.

@Test
	public void testReadAll() {
		List<Orders> expected = new ArrayList<>();
		expected.add(new Orders(1L, 1L, 1L, 20, "Delivered", 2.3f));
		assertEquals(expected, DAO.readAll());
	}

### Integration Tests 

  Mockito is the integration testing system used. This 'mocks' the methods that are run for objects.

@Test
	public void testReadAll() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L, "jordan", "harrison", "jharrison@gmail.com", "0131384685"));

		Mockito.when(dao.readAll()).thenReturn(customers);

		assertEquals(customers, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}


## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Gregor Rule** - *Project work* - https://github.com/gregorule/

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
* big thanks to Chris for his help on this
