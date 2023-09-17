package org.example;
import org.example.entities.*;
import org.example.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int action = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("0.Вихід");
            System.out.println("1.Додати user");
            System.out.println("2.Показати");
            System.out.println("2.add product");
            System.out.println("2.add question");
            System.out.print("->_");
            action = Integer.parseInt(in.nextLine());
            switch(action) {
                case 1:
                    insertUser();
                    break;
                case 2: {
                    showUsers();
                    break;
                }
                case 3: {
                    insertProduct();
                    break;
                }
                case 4: {
                    insertQuestion();
                    break;
                }
            }
        }while(action!=0);
        //insertUser();
    }

    public  static void showUsers() {
        // Get the Hibernate SessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // Open a Hibernate Session
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Query to fetch all users from the database
            Query<User> query = session.createQuery("FROM User", User.class);

            // Execute the query and get the list of users
            List<User> userList = query.getResultList();

            // Display the list of users
            System.out.println("List of Users:");
            for (User user : userList) {
                System.out.println("User ID: " + user.getId());
                System.out.println("Name: " + user.getLastName()+ " "+ user.getLastName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Phone: " + user.getPhone());
                System.out.println();
            }

            session.getTransaction().commit();

        }
    }
    public  static void insertUser() {
        Scanner in = new Scanner(System.in);
        // Get the Hibernate SessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // Open a Hibernate Session
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            User user = new User();
            System.out.println("Вкажіть пошту:");
            String email = in.nextLine();
            user.setEmail(email);

            System.out.println("Вкажіть прізвище:");
            String lastName = in.nextLine();
            user.setLastName(lastName);

            System.out.println("Вкажіть ім'я:");
            String firstName = in.nextLine();
            user.setFirstName(firstName);

            System.out.println("Вкажіть телефон:");
            String phone = in.nextLine();
            user.setPhone(phone);

            System.out.println("Вкажіть пароль:");
            String password = in.nextLine();
            user.setPassword(password);
            session.save(user);
            tx.commit();
        }
    }
        public  static void insertProduct() {
            Scanner in = new Scanner(System.in);
            // Get the Hibernate SessionFactory
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            // Open a Hibernate Session
            try (Session session = sessionFactory.openSession()) {
                Transaction tx = session.beginTransaction();

                Product product = new Product();
                System.out.println("Enter the product name:");
                String name = in.nextLine();
                product.setName(name);

                System.out.println("Enter the product description:");
                String description = in.nextLine();
                product.setDescription(description);

                System.out.println("Enter the product creation date (YYYY-MM-DD):");
                String dateString = in.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date dateCreated = dateFormat.parse(dateString);
                    product.setDateCreated(dateCreated);
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                    tx.rollback();
                    return;
                }
                session.save(product);
                tx.commit();
            }
    }
    public static void insertQuestion() {
        Scanner in = new Scanner(System.in);
        // Get the Hibernate SessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // Open a Hibernate Session
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            Question question = new Question();

            System.out.println("Enter the question text:");
            String text = in.nextLine();
            question.setText(text);

            System.out.println("Enter the question type:");
            String questionType = in.nextLine();
            question.setQuestionType(questionType);

            session.save(question);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}