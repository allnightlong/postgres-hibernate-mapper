postgre-hibernate-mapper
===

postgre-hibernate-mapper is the small project to handle default hibernate id generation strategy.
Main goal of this project is to have solution in one place. Just add this dependency to your project:
	compile 'ru.megadevelopers:postgre-hibernate-mapper:1.0'
, and set dialect in hibernate config:
	hibernate.dialect=ru.megadevelopers.hibernate.dialect.SequencePerTablePostgresDialect

Credits to Burt Beckwith <http://grails.1312388.n4.nabble.com/One-hibernate-sequence-is-used-for-all-Postgres-tables-td1351722.html>