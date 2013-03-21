package com.mycompany.common.util;

import java.util.Date;

public class SystemTime {

	private static TimeSource source;

	private static final TimeSource defaultSource = new TimeSource() {
		public long millis() {
			return System.currentTimeMillis();
		}
	};

	public static long asMillis() {
		return getTimeSource().millis();
	}

	public static Date asDate() {
		return new Date(asMillis());
	}

	public static void reset() {
		setTimeSource(null);
	}

	public static void setTimeSource(TimeSource source) {
		SystemTime.source = source;
	}

	private static TimeSource getTimeSource() {
		return source != null ? source : defaultSource;
	}
}
