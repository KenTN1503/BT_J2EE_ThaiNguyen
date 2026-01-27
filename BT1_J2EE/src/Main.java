public class Main {
    public static void main(String[] args) {
        java.util.List<Book> listBook = new java.util.ArrayList<>();
        java.util.Scanner x = new java.util.Scanner(System.in);

        String msg = """
                \nChuong trinh quan ly sach
                1. Them 1 cuon sach
                2. Xoa 1 cuon sach
                3. Thay doi sach
                4. Xuat thong tin
                5. Tim cuon sach co tua de chua chu \"Lap trinh\"
                6. Lay cuon sach co don gia cao nhat
                7. Tim kiem sach theo tac gia
                0. Thoat
                Chon chuc nang: """;

        int chon;
        do {
            System.out.print(msg);
            chon = x.nextInt();
            x.nextLine(); // bo dong thua

            switch (chon) {
                case 1 -> {
                    Book newBook = new Book();
                    newBook.input();
                    listBook.add(newBook);
                }
                case 2 -> {
                    System.out.print("Nhap vao ma sach can xoa: ");
                    int bookId = x.nextInt();
                    x.nextLine();

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookId)
                            .findFirst()
                            .orElse(null);

                    if (find != null) {
                        listBook.remove(find);
                        System.out.println("Da xoa sach thanh cong");
                    } else {
                        System.out.println("Khong tim thay ma sach can xoa");
                    }
                }
                case 3 -> {
                    System.out.print("Nhap vao ma sach can dieu chinh: ");
                    int bookId = x.nextInt();
                    x.nextLine();

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookId)
                            .findFirst()
                            .orElse(null);

                    if (find != null) {
                        System.out.println("Nhap lai thong tin cho cuon sach nay:");
                        find.input();
                    } else {
                        System.out.println("Khong tim thay ma sach can dieu chinh");
                    }
                }
                case 4 -> {
                    System.out.println("\nXuat thong tin danh sach sach:");
                    listBook.forEach(Book::output);
                }
                case 5 -> {
                    java.util.List<Book> list5 = listBook.stream()
                            .filter(u -> u.getTitle().toLowerCase().contains("lap trinh"))
                            .toList();
                    list5.forEach(Book::output);
                }
                case 6 -> {
                    System.out.print("Nhap so luong sach K muon lay: ");
                    int k = x.nextInt();
                    System.out.print("Nhap gia sach P: ");
                    double p = x.nextDouble();
                    x.nextLine();

                    java.util.List<Book> list6 = listBook.stream()
                            .filter(b -> b.getPrice() <= p)
                            .limit(k)
                            .toList();

                    list6.forEach(Book::output);
                }
                case 7 -> {
                    System.out.print("Nhap danh sach tac gia can tim (cach nhau boi dau phay): ");
                    String line = x.nextLine();
                    java.util.Set<String> authors = java.util.Arrays.stream(line.split(","))
                            .map(String::trim)
                            .map(String::toLowerCase)
                            .filter(s -> !s.isEmpty())
                            .collect(java.util.stream.Collectors.toSet());

                    listBook.stream()
                            .filter(b -> authors.contains(b.getAuthor().toLowerCase()))
                            .forEach(Book::output);
                }
                case 0 -> System.out.println("Ket thuc chuong trinh!");
                default -> System.out.println("Chon sai, vui long chon lai!");
            }

        } while (chon != 0);
    }
}