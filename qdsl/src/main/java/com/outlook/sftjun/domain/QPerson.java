package com.outlook.sftjun.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QPerson extends com.querydsl.sql.RelationalPathBase<Person> {

    private static final long serialVersionUID = 1363561729;

    public static final QPerson person = new QPerson("person");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final com.querydsl.sql.PrimaryKey<Person> primary = createPrimaryKey(id);

    public QPerson(String variable) {
        super(Person.class, forVariable(variable), "null", "person");
        addMetadata();
    }

    public QPerson(String variable, String schema, String table) {
        super(Person.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QPerson(String variable, String schema) {
        super(Person.class, forVariable(variable), schema, "person");
        addMetadata();
    }

    public QPerson(Path<? extends Person> path) {
        super(path.getType(), path.getMetadata(), "null", "person");
        addMetadata();
    }

    public QPerson(PathMetadata metadata) {
        super(Person.class, metadata, "null", "person");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(age, ColumnMetadata.named("age").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(32));
    }

}

