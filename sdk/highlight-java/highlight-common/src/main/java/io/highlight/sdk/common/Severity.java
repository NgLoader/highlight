package io.highlight.sdk.common;

public record Severity(String text, int id, Priority priority) {

	private static final int TRACE_ID = 1;
	private static final int DEBUG_ID = 5;
	private static final int INFO_ID = 9;
	private static final int WARN_ID = 13;
	private static final int ERROR_ID = 17;
	private static final int FATAL_ID = 21;

	public static final Severity TRACE = Severity.trace(Priority.LOW);
	public static final Severity DEBUG = Severity.debug(Priority.LOW);
	public static final Severity INFO = Severity.info(Priority.LOW);
	public static final Severity WARN = Severity.warn(Priority.LOW);
	public static final Severity ERROR = Severity.error(Priority.LOW);
	public static final Severity FATAL = Severity.fatal(Priority.LOW);

	public static Severity trace(String text) {
		return Severity.trace(text, Priority.LOW);
	}

	public static Severity trace(Priority priority) {
		return Severity.trace(null, priority);
	}

	public static Severity trace(String text, Priority priority) {
		return new Severity(text, TRACE_ID, priority);
	}

	public static Severity debug(String text) {
		return Severity.debug(text, Priority.LOW);
	}

	public static Severity debug(Priority priority) {
		return Severity.debug(null, priority);
	}

	public static Severity debug(String text, Priority priority) {
		return new Severity(text, DEBUG_ID, priority);
	}

	public static Severity info(String text) {
		return Severity.info(text, Priority.LOW);
	}

	public static Severity info(Priority priority) {
		return Severity.info(null, priority);
	}

	public static Severity info(String text, Priority priority) {
		return new Severity(text, INFO_ID, priority);
	}

	public static Severity warn(String text) {
		return Severity.warn(text, Priority.LOW);
	}

	public static Severity warn(Priority priority) {
		return Severity.warn(null, priority);
	}

	public static Severity warn(String text, Priority priority) {
		return new Severity(text, WARN_ID, priority);
	}

	public static Severity error(String text) {
		return Severity.error(text, Priority.LOW);
	}

	public static Severity error(Priority priority) {
		return Severity.error(null, priority);
	}

	public static Severity error(String text, Priority priority) {
		return new Severity(text, ERROR_ID, priority);
	}

	public static Severity fatal(String text) {
		return Severity.fatal(text, Priority.LOW);
	}

	public static Severity fatal(Priority priority) {
		return Severity.fatal(null, priority);
	}

	public static Severity fatal(String text, Priority priority) {
		return new Severity(text, FATAL_ID, priority);
	}

	public int id() {
		return this.id + priority.difference;
	}

	public String name() {
		return switch (this.id) {
		case TRACE_ID -> "TRACE";
		case DEBUG_ID -> "DEBUG";
		case INFO_ID -> "INFO";
		case WARN_ID -> "WARN";
		case ERROR_ID -> "ERROR";
		case FATAL_ID -> "FATAL";
		default -> throw new IllegalArgumentException("Unexpected value: " + this.id);
		};
	}

	/**
	 * See: https://opentelemetry.io/docs/reference/specification/logs/data-model/#displaying-severity
	 */
	public String shortName() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(switch (this.id) {
		case TRACE_ID -> "TRACE";
		case DEBUG_ID -> "DEBUG";
		case INFO_ID -> "INFO";
		case WARN_ID -> "WARN";
		case ERROR_ID -> "ERROR";
		case FATAL_ID -> "FATAL";
		default -> throw new IllegalArgumentException("Unexpected value: " + this.id);
		});

		if (this.priority != Priority.LOW) {
			stringBuilder.append(this.priority.difference);
		}

		return stringBuilder.toString();
	}

	public io.opentelemetry.api.logs.Severity toOpenTelemetry() {
		return io.opentelemetry.api.logs.Severity.values()[this.id];
	}

	public static enum Priority {
		LOW(0),
		NORMAL(1),
		MEDIUM(2),
		HIGH(3);

		final int difference;

		private Priority(int difference) {
			this.difference = difference;
		}
	}
}