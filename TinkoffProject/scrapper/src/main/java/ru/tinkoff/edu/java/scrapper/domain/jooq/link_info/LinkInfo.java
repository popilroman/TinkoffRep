/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.domain.jooq.link_info;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import ru.tinkoff.edu.java.scrapper.domain.jooq.DefaultCatalog;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables.Chat;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables.GithubUpdates;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables.Link;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables.StackoverflowUpdates;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LinkInfo extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>LINK_INFO</code>
     */
    public static final LinkInfo LINK_INFO = new LinkInfo();

    /**
     * The table <code>LINK_INFO.CHAT</code>.
     */
    public final Chat CHAT = Chat.CHAT;

    /**
     * The table <code>LINK_INFO.GITHUB_UPDATES</code>.
     */
    public final GithubUpdates GITHUB_UPDATES = GithubUpdates.GITHUB_UPDATES;

    /**
     * The table <code>LINK_INFO.LINK</code>.
     */
    public final Link LINK = Link.LINK;

    /**
     * The table <code>LINK_INFO.STACKOVERFLOW_UPDATES</code>.
     */
    public final StackoverflowUpdates STACKOVERFLOW_UPDATES = StackoverflowUpdates.STACKOVERFLOW_UPDATES;

    /**
     * No further instances allowed
     */
    private LinkInfo() {
        super("LINK_INFO", null);
    }


    @Override
    @NotNull
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    @NotNull
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Chat.CHAT,
            GithubUpdates.GITHUB_UPDATES,
            Link.LINK,
            StackoverflowUpdates.STACKOVERFLOW_UPDATES
        );
    }
}
