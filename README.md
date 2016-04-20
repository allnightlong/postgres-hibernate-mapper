postgre-hibernate-mapper
===
Project is deprecated.
===
This project should be considered deprecated, as in hibernate 4.1.3 sequence-per-table was added as the new config option ([issue](https://hibernate.atlassian.net/browse/HHH-6790),
[commit](https://github.com/hibernate/hibernate-orm/commit/cfa729d8b3979ef7c8f1c7ea0b0710429540a183)).

Config should look something like this (grails app example):


    grails.gorm.default.mapping = {
    	id generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator',
    			params: [prefer_sequence_per_entity: true, sequence_per_entity_suffix: '_sequence']
    }


[![Build Status](https://drone.io/github.com/allnightlong/postgres-hibernate-mapper/status.png)](https://drone.io/github.com/allnightlong/postgres-hibernate-mapper/latest)

postgre-hibernate-mapper is the small project to handle default hibernate id generation strategy.
Main goal of this project is to have solution in one place.

HOW-TO
---
Just add this dependency to your project:
for hibernate 3

	compile 'ru.megadevelopers:postgres-hibernate-mapper:1.0'

for hibernate 4

	compile 'ru.megadevelopers:postgres-hibernate-mapper:2.0'

Then set dialect in hibernate config:

	hibernate.dialect=ru.megadevelopers.hibernate.dialect.SequencePerTablePostgresDialect

Credits to Burt Beckwith <http://grails.1312388.n4.nabble.com/One-hibernate-sequence-is-used-for-all-Postgres-tables-td1351722.html>
