package tektonikal.missingno.enterprise.impl.asset;

import tektonikal.missingno.enterprise.pub.asset.InputStreamReader;
import tektonikal.missingno.enterprise.pub.asset.StreamReader;

import java.io.InputStream;

public class GenericInputStreamReader implements InputStreamReader {


    @Override
    public StreamReader getGenericStreamReader(InputStream is) {
        return new InputStreamReaderImpl(is);
    }
}
