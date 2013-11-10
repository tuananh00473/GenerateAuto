<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence"
                           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                           xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
                                               http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">

    <persistence-unit name="NewPersistenceUnit" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.ejb.HibernatePersistence</provider>
        $tables:{table|
        <class>$packageName$.entity.$table.TableName$</class>
        }$
    </persistence-unit>
</persistence>