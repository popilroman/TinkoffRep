package ru.tinkoff.edu.java.scrapper.migrations;

import org.junit.jupiter.api.Assertions;
import ru.tinkoff.edu.java.scrapper.integrations.IntegrationEnvironment;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MigrationsTest extends IntegrationEnvironment {
    @Test
    void checkMigrationsLinkOpen(){
        String SQL_REQUEST_FROM_LINK = """ 
                SELECT * FROM Link
                """;
        try (Connection connection = POSTGRE_SQL_CONTAINER.createConnection("")) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SQL_REQUEST_FROM_LINK);
            assertTrue(result.next());
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
            Assertions.fail(exception.getMessage());
        }
    }

    @Test
    void checkMigrationsChatOpen(){
        String SQL_REQUEST_FROM_CHAT = """ 
                SELECT * FROM chat
                """;
        try (Connection connection = POSTGRE_SQL_CONTAINER.createConnection("")) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SQL_REQUEST_FROM_CHAT);
            assertTrue(result.next());
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
            Assertions.fail(exception.getMessage());
        }
    }

    @Test
    void checkMigrationsChatLinkOpen(){
        String SQL_REQUEST_FROM_CHAT = """ 
                SELECT * FROM chat_link
                """;
        try (Connection connection = POSTGRE_SQL_CONTAINER.createConnection("")) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SQL_REQUEST_FROM_CHAT);
            assertTrue(result.next());
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
            Assertions.fail(exception.getMessage());
        }
    }
}
