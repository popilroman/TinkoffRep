/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.domain.jooq.link_info;


import javax.annotation.processing.Generated;

import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables.Chat;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables.GithubUpdates;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables.Link;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables.StackoverflowUpdates;


/**
 * Convenience access to all tables in LINK_INFO.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>LINK_INFO.CHAT</code>.
     */
    public static final Chat CHAT = Chat.CHAT;

    /**
     * The table <code>LINK_INFO.GITHUB_UPDATES</code>.
     */
    public static final GithubUpdates GITHUB_UPDATES = GithubUpdates.GITHUB_UPDATES;

    /**
     * The table <code>LINK_INFO.LINK</code>.
     */
    public static final Link LINK = Link.LINK;

    /**
     * The table <code>LINK_INFO.STACKOVERFLOW_UPDATES</code>.
     */
    public static final StackoverflowUpdates STACKOVERFLOW_UPDATES = StackoverflowUpdates.STACKOVERFLOW_UPDATES;
}
