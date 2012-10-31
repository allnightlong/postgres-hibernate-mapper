package ru.megadevelopers.hibernate.dialect;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.type.Type;

import java.util.Properties;

import static org.hibernate.util.StringHelper.isEmpty;

/**
 * Creates a sequence per table instead of the default behavior of one sequence.
 * From <a href='http://www.hibernate.org/296.html'>http://www.hibernate.org/296.html</a>
 *
 * @author Burt Beckwith
 * @author Tigran Kavanosyan
 */
public class SequencePerTablePostgresDialect extends PostgreSQLDialect {
	/**
	 * Get the native identifier generator class.
	 *
	 * @return SequencePerTableGenerator.
	 */
	@Override
	public Class<?> getNativeIdentifierGeneratorClass() {
		return SequencePerTableGenerator.class;
	}

	/**
	 * Creates a sequence per table instead of the default behavior of one sequence.
	 */
	public static class SequencePerTableGenerator extends SequenceGenerator {
		/**
		 * {@inheritDoc}
		 * If the parameters do not contain a {@link SequenceGenerator#SEQUENCE} name, we assign one based on the table name.
		 */
		@Override
		public void configure(Type type, Properties params, Dialect dialect) {
			String sequence = params.getProperty(SEQUENCE);
			if (isEmpty(sequence)) {
				String tableName = params.getProperty(PersistentIdentifierGenerator.TABLE);
				if (isEmpty(tableName)) {
					params.setProperty(SEQUENCE, tableName + "_" + SEQUENCE);
				}
			}
			super.configure(type, params, dialect);
		}

		private boolean isEmpty(String sequence) {
			return sequence == null || sequence.length() == 0;
		}
	}
}
