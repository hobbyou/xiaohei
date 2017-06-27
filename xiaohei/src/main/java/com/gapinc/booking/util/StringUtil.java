package com.gapinc.booking.util;

import java.util.UUID;

public class StringUtil {
	public static final String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
