package com.ashwinswaroop.jailbirdsbot.loader;

import java.io.IOException;
import java.util.Properties;

public interface StreamLoader {
    Properties loadStream() throws IOException;
}
