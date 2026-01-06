import java.util.List;

public class DataSeeder {

    public static void seed(LibraryService library) {

        List<Book> books = List.of(
                new Book(100, "Под игото", "Иван Вазов", "Роман", false),
                new Book(101, "Немили-недраги", "Иван Вазов", "Повест", false),
                new Book(102, "Бай Ганьо", "Алеко Константинов", "Сатира", false),
                new Book(103, "Железният светилник", "Димитър Талев", "Роман", false),
                new Book(104, "Тютюн", "Димитър Димов", "Роман", false),
                new Book(105, "История славянобългарска", "Паисий Хилендарски", "История", true),
                new Book(106, "Записки по българските въстания", "Захари Стоянов", "История", true),
                new Book(107, "Под манастирската лоза", "Елин Пелин", "Разкази", false),
                new Book(108, "Старопланински легенди", "Йордан Йовков", "Разкази", false),
                new Book(109, "Антихрист", "Емилиян Станев", "Роман", false),
                new Book(110, "1984", "George Orwell", "Dystopia", false),
                new Book(111, "Animal Farm", "George Orwell", "Satire", false),
                new Book(112, "Brave New World", "Aldous Huxley", "Dystopia", false),
                new Book(113, "Fahrenheit 451", "Ray Bradbury", "Dystopia", false),
                new Book(114, "The Hobbit", "J.R.R. Tolkien", "Fantasy", false),
                new Book(115, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", false),
                new Book(116, "Crime and Punishment", "Fyodor Dostoevsky", "Classic", false),
                new Book(117, "The Brothers Karamazov", "Fyodor Dostoevsky", "Classic", false),
                new Book(118, "Don Quixote", "Miguel de Cervantes", "Classic", true),
                new Book(119, "The Divine Comedy", "Dante Alighieri", "Classic", true)
        );

        books.forEach(library::addBookDirect);

        List<Reader> readers = List.of(
                new Reader(200, "Ivan Petrov"),
                new Reader(201, "Maria Ivanova"),
                new Reader(202, "Georgi Dimitrov"),
                new Reader(203, "Elena Nikolova"),
                new Reader(204, "Petar Stoyanov"),
                new Reader(205, "Daniela Georgieva"),
                new Reader(206, "Nikolay Hristov"),
                new Reader(207, "Teodora Marinova"),
                new Reader(208, "Vladimir Kolev"),
                new Reader(209, "Rosen Vasilev")
        );

        readers.forEach(r -> {
            library.registerReader(r);
            library.approveReader(r.getId());
        });
    }
}

