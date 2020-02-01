package iot.lviv.ua.ViewAndController;

import iot.lviv.ua.model.*;
import iot.lviv.ua.service.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public class MyView {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("A", "   A - Select all table");
        menu.put("B", "   B - Select structure of DB");

        menu.put("0", "   0 - Table: User");
        menu.put("01", "  01 - Create for User");
        menu.put("02", "  02 - Update User");
        menu.put("03", "  03 - Delete from User");
        menu.put("04", "  04 - Select User");
        menu.put("05", "  05 - Find User by ID");

        menu.put("1", "   1 - Table: Address");
        menu.put("11", "  11 - Create for Address");
        menu.put("12", "  12 - Update Address");
        menu.put("13", "  13 - Delete from Address");
        menu.put("14", "  14 - Select Address");
        menu.put("15", "  15 - Find Address by ID");

        menu.put("2", "   2 - Table: Artist");
        menu.put("21", "  21 - Create for Artist");
        menu.put("22", "  22 - Update Artist");
        menu.put("23", "  23 - Delete from Artist");
        menu.put("24", "  24 - Select Artist");
        menu.put("25", "  25 - Find Artist by ID");

        menu.put("3", "   3 - Table: Credential");
        menu.put("31", "  31 - Create for Credential");
        menu.put("32", "  32 - Update Credential");
        menu.put("33", "  33 - Delete from Credential");
        menu.put("34", "  34 - Select Credential");
        menu.put("35", "  35 - Find Credential by ID");

        menu.put("4", "   4 - Table: Event");
        menu.put("41", "  41 - Create for Event");
        menu.put("42", "  42 - Update Event");
        menu.put("43", "  43 - Delete from Event");
        menu.put("44", "  44 - Select Event");
        menu.put("45", "  45 - Find Event by ID");

        menu.put("5", "   5 - Table: OrderEvent");
        menu.put("51", "  51 - Create for OrderEvent");
        menu.put("52", "  52 - Update OrderEvent");
        menu.put("53", "  53 - Delete from OrderEvent");
        menu.put("54", "  54 - Select OrderEvent");
        menu.put("55", "  55 - Find OrderEvent by ID");

        menu.put("6", "   6 - Table: OrderPassage");
        menu.put("61", "  61 - Create for OrderPassage");
        menu.put("62", "  62 - Update OrderPassage");
        menu.put("63", "  63 - Delete from OrderPassage");
        menu.put("64", "  64 - Select OrderPassage");
        menu.put("65", "  65 - Find OrderPassage by ID");

        menu.put("7", "   7 - Table: Passage");
        menu.put("71", "  71 - Create for Passage");
        menu.put("72", "  72 - Update Passage");
        menu.put("73", "  73 - Delete from Passage");
        menu.put("74", "  74 - Select Passage");
        menu.put("75", "  75 - Find Passage by ID");

        menu.put("8", "   8 - Table: TicketEvent");
        menu.put("81", "  81 - Create for TicketEvent");
        menu.put("82", "  82 - Update TicketEvent");
        menu.put("83", "  83 - Delete from TicketEvent");
        menu.put("84", "  84 - Select TicketEvent");
        menu.put("85", "  85 - Find TicketEvent by ID");

        menu.put("9", "   9 - Table: TicketPassage");
        menu.put("91", "  91 - Create for TicketPassage");
        menu.put("92", "  92 - Update TicketPassage");
        menu.put("93", "  93 - Delete from TicketPassage");
        menu.put("94", "  94 - Select TicketPassage");
        menu.put("95", "  95 - Find TicketPassage by ID");

        menu.put("Q", "   Q - exit");

        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createForAddress);
        methodsMenu.put("12", this::updateAddress);
        methodsMenu.put("13", this::deleteFromAddress);
        methodsMenu.put("14", this::selectAddress);
        methodsMenu.put("15", this::findAddressByID);

        methodsMenu.put("21", this::createForArtist);
        methodsMenu.put("22", this::updateArtist);
        methodsMenu.put("23", this::deleteFromArtist);
        methodsMenu.put("24", this::selectArtist);
        methodsMenu.put("25", this::findArtistByID);

        methodsMenu.put("31", this::createForCredential);
        methodsMenu.put("32", this::updateCredential);
        methodsMenu.put("33", this::deleteFromCredential);
        methodsMenu.put("34", this::selectCredential);
        methodsMenu.put("35", this::findCredentialByID);

        methodsMenu.put("41", this::createForEvent);
        methodsMenu.put("42", this::updateEvent);
        methodsMenu.put("43", this::deleteFromEvent);
        methodsMenu.put("44", this::selectEvent);
        methodsMenu.put("45", this::findEventByID);

        methodsMenu.put("51", this::createForOrderEvent);
        methodsMenu.put("52", this::updateOrderEvent);
        methodsMenu.put("53", this::deleteFromOrderEvent);
        methodsMenu.put("54", this::selectOrderEvent);
        methodsMenu.put("55", this::findOrderEventByID);

        methodsMenu.put("61", this::createForOrderPassage);
        methodsMenu.put("62", this::updateOrderPassage);
        methodsMenu.put("63", this::deleteFromOrderPassage);
        methodsMenu.put("64", this::selectOrderPassage);
        methodsMenu.put("65", this::findOrderPassageByID);

        methodsMenu.put("71", this::createForPassage);
        methodsMenu.put("72", this::updatePassage);
        methodsMenu.put("73", this::deleteFromPassage);
        methodsMenu.put("74", this::selectPassage);
        methodsMenu.put("75", this::findPassageByID);

        methodsMenu.put("81", this::createForTicketEvent);
        methodsMenu.put("82", this::updateTicketEvent);
        methodsMenu.put("83", this::deleteFromTicketEvent);
        methodsMenu.put("84", this::selectTicketEvent);
        methodsMenu.put("85", this::findTicketEventByID);

        methodsMenu.put("91", this::createForTicketPassage);
        methodsMenu.put("92", this::updateTicketPassage);
        methodsMenu.put("93", this::deleteFromTicketPassage);
        methodsMenu.put("94", this::selectTicketPassage);
        methodsMenu.put("95", this::findTicketPassageByID);

        methodsMenu.put("01", this::createForUser);
        methodsMenu.put("02", this::updateUser);
        methodsMenu.put("03", this::deleteFromUser);
        methodsMenu.put("04", this::selectUser);
        methodsMenu.put("05", this::findUserByID);
    }

    //--------------------------------------------------------//

    private void selectAllTable() throws SQLException {
        selectAddress();
        selectArtist();
        selectCredential();
        selectEvent();
        selectOrderEvent();
        selectOrderPassage();
        selectPassage();
        selectTicketEvent();
        selectTicketPassage();
        selectUser();
    }

    //--------------------------------------------------------//

    private void deleteFromAddress() throws SQLException {
        System.out.println("Input ID for Address: ");
        int id = Integer.parseInt(input.nextLine());
        AddressService addressService = new AddressService();
        int count = addressService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForAddress() throws SQLException {
        System.out.println("Input city for Address: ");
        String city = input.nextLine();
        System.out.println("Input street for Address: ");
        String street = input.nextLine();
        System.out.println("Input number for Address: ");
        int number = Integer.parseInt(input.nextLine());
        AddressEntity entity = new AddressEntity(city, street, number);

        AddressService addressService = new AddressService();
        int count = addressService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateAddress() throws SQLException {
        System.out.println("Input ID for Address: ");
        String city = input.nextLine();
        System.out.println("Input street for Address: ");
        String street = input.nextLine();
        System.out.println("Input number for Address: ");
        int number = Integer.parseInt(input.nextLine());
        AddressEntity entity = new AddressEntity(city, street, number);

        AddressService addressService = new AddressService();
        int count = addressService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectAddress() throws SQLException {
        System.out.println("\nTable: Address");
        AddressService addressService = new AddressService();
        List<AddressEntity> addresses = addressService.findAll();
        for (AddressEntity entity : addresses) {
            System.out.println(entity);
        }
    }

    private void findAddressByID() throws SQLException {
        System.out.println("Input ID for Address: ");
        int id = Integer.parseInt(input.nextLine());
        AddressService addressService = new AddressService();
        AddressEntity entity = addressService.findById(id);
        System.out.println(entity);
    }

    //--------------------------------------------------------//

    private void deleteFromArtist() throws SQLException {
        System.out.println("Input ID for Artist: ");
        int id = Integer.parseInt(input.nextLine());
        ArtistService artistService = new ArtistService();
        int count = artistService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForArtist() throws SQLException {
        System.out.println("Input name for Artist: ");
        String name = input.nextLine();
        System.out.println("Input surname for Artist: ");
        String surname = input.nextLine();
        System.out.println("Input nickname for Artist: ");
        String nickname = input.nextLine();
        ArtistEntity entity = new ArtistEntity(name, surname, nickname);

        ArtistService artistService = new ArtistService();
        int count = artistService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateArtist() throws SQLException {
        System.out.println("Input name for Artist: ");
        String name = input.nextLine();
        System.out.println("Input surname for Artist: ");
        String surname = input.nextLine();
        System.out.println("Input nickname for Artist: ");
        String nickname = input.nextLine();
        ArtistEntity entity = new ArtistEntity(name, surname, nickname);

        ArtistService artistService = new ArtistService();
        int count = artistService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectArtist() throws SQLException {
        System.out.println("\nTable: Artist");
        ArtistService artistService = new ArtistService();
        List<ArtistEntity> artists = artistService.findAll();
        for (ArtistEntity entity : artists) {
            System.out.println(entity);
        }
    }

    private void findArtistByID() throws SQLException {
        System.out.println("Input ID for Artist: ");
        int id = Integer.parseInt(input.nextLine());
        ArtistService artistService = new ArtistService();
        ArtistEntity entity = artistService.findById(id);
        System.out.println(entity);
    }

    //--------------------------------------------------------//

    private void deleteFromCredential() throws SQLException {
        System.out.println("Input ID for Credential: ");
        int id = Integer.parseInt(input.nextLine());
        CredentialService credentialService = new CredentialService();
        int count = credentialService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForCredential() throws SQLException {
        System.out.println("Input password for Credential: ");
        String password = input.nextLine();
        System.out.println("Input login for Credential: ");
        String login = input.nextLine();
        System.out.println("Input telephone for Credential: ");
        String telephone = input.nextLine();
        System.out.println("Input userId for Credential: ");
        int userId = Integer.parseInt(input.nextLine());
        System.out.println("Input email for Credential: ");
        String email = input.nextLine();
        CredentialEntity entity = new CredentialEntity(password, login,
                telephone, userId, email);

        CredentialService credentialService = new CredentialService();
        int count = credentialService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCredential() throws SQLException {
        System.out.println("Input password for Credential: ");
        String password = input.nextLine();
        System.out.println("Input login for Credential: ");
        String login = input.nextLine();
        System.out.println("Input telephone for Credential: ");
        String telephone = input.nextLine();
        System.out.println("Input userId for Credential: ");
        int userId = Integer.parseInt(input.nextLine());
        System.out.println("Input email for Credential: ");
        String email = input.nextLine();
        CredentialEntity entity = new CredentialEntity(password, login,
                telephone, userId, email);

        CredentialService credentialService = new CredentialService();
        int count = credentialService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectCredential() throws SQLException {
        System.out.println("\nTable: Credential");
        CredentialService credentialService = new CredentialService();
        List<CredentialEntity> credentials = credentialService.findAll();
        for (CredentialEntity entity : credentials) {
            System.out.println(entity);
        }
    }

    private void findCredentialByID() throws SQLException {
        System.out.println("Input ID for Credential: ");
        int id = Integer.parseInt(input.nextLine());
        CredentialService credentialService = new CredentialService();
        CredentialEntity entity = credentialService.findById(id);
        System.out.println(entity);
    }

    //--------------------------------------------------------//

    private void deleteFromEvent() throws SQLException {
        System.out.println("Input ID for Event: ");
        int id = Integer.parseInt(input.nextLine());
        EventService eventService = new EventService();
        int count = eventService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForEvent() throws SQLException {
        System.out.println("Input date for Event: ");
        String date = input.nextLine();
        System.out.println("Input description for Event: ");
        String description = input.nextLine();
        System.out.println("Input addressId for Event: ");
        int addressId = Integer.parseInt(input.nextLine());
        System.out.println("Input artistId for Event: ");
        int artistId = Integer.parseInt(input.nextLine());
        System.out.println("Input eventType for Event: ");
        String eventType = input.nextLine();
        EventEntity entity = new EventEntity(date, description,
                addressId, artistId, eventType);

        EventService eventService = new EventService();
        int count = eventService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateEvent() throws SQLException {
        System.out.println("Input date for Event: ");
        String date = input.nextLine();
        System.out.println("Input description for Event: ");
        String description = input.nextLine();
        System.out.println("Input addressId for Event: ");
        int addressId = Integer.parseInt(input.nextLine());
        System.out.println("Input artistId for Event: ");
        int artistId = Integer.parseInt(input.nextLine());
        System.out.println("Input eventType for Event: ");
        String eventType = input.nextLine();
        EventEntity entity = new EventEntity(date, description,
                addressId, artistId, eventType);

        EventService eventService = new EventService();
        int count = eventService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectEvent() throws SQLException {
        System.out.println("\nTable: Event");
        EventService eventService = new EventService();
        List<EventEntity> events = eventService.findAll();
        for (EventEntity entity : events) {
            System.out.println(entity);
        }
    }

    private void findEventByID() throws SQLException {
        System.out.println("Input ID for Event: ");
        int id = Integer.parseInt(input.nextLine());
        EventService eventService = new EventService();
        EventEntity entity = eventService.findById(id);
        System.out.println(entity);
    }

    //--------------------------------------------------------//

    private void deleteFromOrderEvent() throws SQLException {
        System.out.println("Input ID for OrderEvent: ");
        int id = Integer.parseInt(input.nextLine());
        OrderEventService orderEventService = new OrderEventService();
        int count = orderEventService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForOrderEvent() throws SQLException {
        System.out.println("Input is payed for OrderEvent: ");
        boolean payed = Boolean.getBoolean(input.nextLine());
        System.out.println("Input userId for OrderEvent: ");
        int userId = Integer.parseInt(input.nextLine());
        System.out.println("Input delivery for OrderEvent: ");
        String delivery = input.nextLine();
        System.out.println("Input paymentMethod for OrderEvent: ");
        String paymentMethod = input.nextLine();
        System.out.println("Input eventId for OrderEvent: ");
        int eventId = Integer.parseInt(input.nextLine());
        OrderEventEntity entity = new OrderEventEntity(payed, userId,
                delivery, paymentMethod, eventId);

        OrderEventService orderEventService = new OrderEventService();
        int count = orderEventService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateOrderEvent() throws SQLException {
        System.out.println("Input is payed for OrderEvent: ");
        boolean payed = Boolean.getBoolean(input.nextLine());
        System.out.println("Input userId for OrderEvent: ");
        int userId = Integer.parseInt(input.nextLine());
        System.out.println("Input delivery for OrderEvent: ");
        String delivery = input.nextLine();
        System.out.println("Input paymentMethod for OrderEvent: ");
        String paymentMethod = input.nextLine();
        System.out.println("Input eventId for OrderEvent: ");
        int eventId = Integer.parseInt(input.nextLine());
        OrderEventEntity entity = new OrderEventEntity(payed, userId,
                delivery, paymentMethod, eventId);

        OrderEventService orderEventService = new OrderEventService();
        int count = orderEventService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectOrderEvent() throws SQLException {
        System.out.println("\nTable: OrderEvent");
        OrderEventService orderEventService = new OrderEventService();
        List<OrderEventEntity> orderedEvents = orderEventService.findAll();
        for (OrderEventEntity entity : orderedEvents) {
            System.out.println(entity);
        }
    }

    private void findOrderEventByID() throws SQLException {
        System.out.println("Input ID for OrderEvent: ");
        int id = Integer.parseInt(input.nextLine());
        OrderEventService orderEventService = new OrderEventService();
        OrderEventEntity entity = orderEventService.findById(id);
        System.out.println(entity);
    }

    //--------------------------------------------------------//

    private void deleteFromOrderPassage() throws SQLException {
        System.out.println("Input ID for OrderPassage: ");
        int id = Integer.parseInt(input.nextLine());
        OrderPassageService orderPassageService = new OrderPassageService();
        int count = orderPassageService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForOrderPassage() throws SQLException {
        System.out.println("Input is payed for OrderPassage: ");
        boolean payed = Boolean.getBoolean(input.nextLine());
        System.out.println("Input userId for OrderPassage: ");
        int userId = Integer.parseInt(input.nextLine());
        System.out.println("Input delivery for OrderPassage: ");
        String delivery = input.nextLine();
        System.out.println("Input paymentMethod for OrderPassage: ");
        String paymentMethod = input.nextLine();
        System.out.println("Input passageId for OrderPassage: ");
        int passageId = Integer.parseInt(input.nextLine());
        OrderPassageEntity entity = new OrderPassageEntity(payed, userId,
                delivery, paymentMethod, passageId);

        OrderPassageService orderPassageService = new OrderPassageService();
        int count = orderPassageService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateOrderPassage() throws SQLException {
        System.out.println("Input is payed for OrderPassage: ");
        boolean payed = Boolean.getBoolean(input.nextLine());
        System.out.println("Input userId for OrderPassage: ");
        int userId = Integer.parseInt(input.nextLine());
        System.out.println("Input delivery for OrderPassage: ");
        String delivery = input.nextLine();
        System.out.println("Input paymentMethod for OrderPassage: ");
        String paymentMethod = input.nextLine();
        System.out.println("Input passageId for OrderPassage: ");
        int passageId = Integer.parseInt(input.nextLine());
        OrderPassageEntity entity = new OrderPassageEntity(payed, userId,
                delivery, paymentMethod, passageId);

        OrderPassageService orderPassageService = new OrderPassageService();
        int count = orderPassageService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectOrderPassage() throws SQLException {
        System.out.println("\nTable: OrderPassage");
        OrderPassageService orderPassageService = new OrderPassageService();
        List<OrderPassageEntity> orderedPassages = orderPassageService.findAll();
        for (OrderPassageEntity entity : orderedPassages) {
            System.out.println(entity);
        }
    }

    private void findOrderPassageByID() throws SQLException {
        System.out.println("Input ID for OrderPassage: ");
        int id = Integer.parseInt(input.nextLine());
        OrderPassageService orderPassageService = new OrderPassageService();
        OrderPassageEntity entity = orderPassageService.findById(id);
        System.out.println(entity);
    }

    //--------------------------------------------------------//

    private void deleteFromPassage() throws SQLException {
        System.out.println("Input ID for Passage: ");
        int id = Integer.parseInt(input.nextLine());
        PassageService passageService = new PassageService();
        int count = passageService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForPassage() throws SQLException {
        System.out.println("Input arrival city for Passage: ");
        String arrivalCity = input.nextLine();
        System.out.println("Input departure city for Passage: ");
        String departureCity = input.nextLine();
        System.out.println("Input arrival time for Passage: ");
        String arrivalTime = input.nextLine();
        System.out.println("Input departure time for Passage: ");
        String departureTime = input.nextLine();
        System.out.println("Input number for Passage: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.println("Input passage type for Passage: ");
        String passageType = input.nextLine();
        System.out.println("Input company for Passage: ");
        String company = input.nextLine();
        PassageEntity entity = new PassageEntity(arrivalCity, departureCity,
                arrivalTime, departureTime, number, passageType, company);

        PassageService passageService = new PassageService();
        int count = passageService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updatePassage() throws SQLException {
        System.out.println("Input arrival city for Passage: ");
        String arrivalCity = input.nextLine();
        System.out.println("Input departure city for Passage: ");
        String departureCity = input.nextLine();
        System.out.println("Input arrival time for Passage: ");
        String arrivalTime = input.nextLine();
        System.out.println("Input departure time for Passage: ");
        String departureTime = input.nextLine();
        System.out.println("Input number for Passage: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.println("Input passage type for Passage: ");
        String passageType = input.nextLine();
        System.out.println("Input company for Passage: ");
        String company = input.nextLine();
        PassageEntity entity = new PassageEntity(arrivalCity, departureCity,
                arrivalTime, departureTime, number, passageType, company);

        PassageService passageService = new PassageService();
        int count = passageService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectPassage() throws SQLException {
        System.out.println("\nTable: Passage");
        PassageService passageService = new PassageService();
        List<PassageEntity> passages = passageService.findAll();
        for (PassageEntity entity : passages) {
            System.out.println(entity);
        }
    }

    private void findPassageByID() throws SQLException {
        System.out.println("Input ID for Passage: ");
        int id = Integer.parseInt(input.nextLine());
        PassageService passageService = new PassageService();
        PassageEntity entity = passageService.findById(id);
        System.out.println(entity);
    }

    //--------------------------------------------------------//

    private void deleteFromTicketEvent() throws SQLException {
        System.out.println("Input ID for TicketEvent: ");
        int id = Integer.parseInt(input.nextLine());
        TicketEventService ticketEventService = new TicketEventService();
        int count = ticketEventService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForTicketEvent() throws SQLException {
        System.out.println("Input number for TicketEvent: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.println("Input row for TicketEvent: ");
        int row = Integer.parseInt(input.nextLine());
        System.out.println("Input price for TicketEvent: ");
        BigDecimal price = new BigDecimal(input.nextLine());
        System.out.println("Input is free for TicketEvent: ");
        Boolean free = Boolean.getBoolean(input.nextLine());
        System.out.println("Input place for TicketEvent: ");
        int place = Integer.parseInt(input.nextLine());
        System.out.println("Input eventId for TicketEvent: ");
        int eventId = Integer.parseInt(input.nextLine());
        TicketEventEntity entity = new TicketEventEntity(number, row,
                price, free, place, eventId);

        TicketEventService ticketEventService = new TicketEventService();
        int count = ticketEventService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateTicketEvent() throws SQLException {
        System.out.println("Input number for TicketEvent: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.println("Input row for TicketEvent: ");
        int row = Integer.parseInt(input.nextLine());
        System.out.println("Input price for TicketEvent: ");
        BigDecimal price = new BigDecimal(input.nextLine());
        System.out.println("Input is free for TicketEvent: ");
        boolean free = Boolean.getBoolean(input.nextLine());
        System.out.println("Input place for TicketEvent: ");
        int place = Integer.parseInt(input.nextLine());
        System.out.println("Input eventId for TicketEvent: ");
        int eventId = Integer.parseInt(input.nextLine());
        TicketEventEntity entity = new TicketEventEntity(number, row,
                price, free, place, eventId);

        TicketEventService ticketEventService = new TicketEventService();
        int count = ticketEventService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectTicketEvent() throws SQLException {
        System.out.println("\nTable: TicketEvent");
        TicketEventService ticketEventService = new TicketEventService();
        List<TicketEventEntity> eventTickets = ticketEventService.findAll();
        for (TicketEventEntity entity : eventTickets) {
            System.out.println(entity);
        }
    }

    private void findTicketEventByID() throws SQLException {
        System.out.println("Input ID for TicketEvent: ");
        int id = Integer.parseInt(input.nextLine());
        TicketEventService ticketEventService = new TicketEventService();
        TicketEventEntity entity = ticketEventService.findById(id);
        System.out.println(entity);
    }

    //--------------------------------------------------------//

    private void deleteFromTicketPassage() throws SQLException {
        System.out.println("Input ID for TicketPassage: ");
        int id = Integer.parseInt(input.nextLine());
        TicketPassageService ticketPassageService = new TicketPassageService();
        int count = ticketPassageService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForTicketPassage() throws SQLException {
        System.out.println("Input row for TicketPassage: ");
        int row = Integer.parseInt(input.nextLine());
        System.out.println("Input number for TicketPassage: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.println("Input is free for TicketPassage: ");
        boolean free = Boolean.getBoolean(input.nextLine());
        System.out.println("Input price for TicketPassage: ");
        BigDecimal price = new BigDecimal(input.nextLine());
        System.out.println("Input class for TicketPassage: ");
        String passageClass = input.nextLine();
        System.out.println("Input passageId for TicketPassage: ");
        int passageId = Integer.parseInt(input.nextLine());
        TicketPassageEntity entity = new TicketPassageEntity(row, number,
                free, price, passageClass, passageId);

        TicketPassageService ticketPassageService = new TicketPassageService();
        int count = ticketPassageService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateTicketPassage() throws SQLException {
        System.out.println("Input row for TicketPassage: ");
        int row = Integer.parseInt(input.nextLine());
        System.out.println("Input number for TicketPassage: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.println("Input is free for TicketPassage: ");
        boolean free = Boolean.getBoolean(input.nextLine());
        System.out.println("Input price for TicketPassage: ");
        BigDecimal price = new BigDecimal(input.nextLine());
        System.out.println("Input class for TicketPassage: ");
        String passageClass = input.nextLine();
        System.out.println("Input passageId for TicketPassage: ");
        int passageId = Integer.parseInt(input.nextLine());
        TicketPassageEntity entity = new TicketPassageEntity(row, number,
                free, price, passageClass, passageId);

        TicketPassageService ticketPassageService = new TicketPassageService();
        int count = ticketPassageService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectTicketPassage() throws SQLException {
        System.out.println("\nTable: TicketPassage");
        TicketPassageService ticketPassageService = new TicketPassageService();
        List<TicketPassageEntity> passageTickets = ticketPassageService.findAll();
        for (TicketPassageEntity entity : passageTickets) {
            System.out.println(entity);
        }
    }

    private void findTicketPassageByID() throws SQLException {
        System.out.println("Input ID for TicketPassage: ");
        int id = Integer.parseInt(input.nextLine());
        TicketPassageService ticketPassageService = new TicketPassageService();
        TicketPassageEntity entity = ticketPassageService.findById(id);
        System.out.println(entity);
    }

    //--------------------------------------------------------//

    private void deleteFromUser() throws SQLException {
        System.out.println("Input ID for User: ");
        int id = Integer.parseInt(input.nextLine());
        UserService userService = new UserService();
        int count = userService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForUser() throws SQLException {
        System.out.println("Input name for User: ");
        String name = input.nextLine();
        System.out.println("Input surname for User: ");
        String surname = input.nextLine();
        UserEntity entity = new UserEntity(name, surname);

        UserService userService = new UserService();
        int count = userService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateUser() throws SQLException {
        System.out.println("Input name for User: ");
        String name = input.nextLine();
        System.out.println("Input surname for User: ");
        String surname = input.nextLine();
        UserEntity entity = new UserEntity(name, surname);

        UserService userService = new UserService();
        int count = userService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectUser() throws SQLException {
        System.out.println("\nTable: User");
        UserService userService = new UserService();
        List<UserEntity> users = userService.findAll();
        for (UserEntity entity : users) {
            System.out.println(entity);
        }
    }

    private void findUserByID() throws SQLException {
        System.out.println("Input ID for User: ");
        int id = Integer.parseInt(input.nextLine());
        UserService userService = new UserService();
        UserEntity entity = userService.findById(id);
        System.out.println(entity);
    }

    //--------------------------------------------------------//

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}
