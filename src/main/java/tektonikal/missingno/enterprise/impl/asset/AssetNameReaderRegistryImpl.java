package tektonikal.missingno.enterprise.impl.asset;

import tektonikal.missingno.enterprise.pub.asset.AssetNameReaderRegistry;
import tektonikal.missingno.enterprise.pub.asset.AssetNameSupplier;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AssetNameReaderRegistryImpl implements AssetNameReaderRegistry {

    public static final AssetNameReaderRegistry instance;

    static {
        instance = new AssetNameReaderRegistryImpl();
        instance.register(new AssetNameReaderImpl());
    }

    protected volatile transient Map<Class<?>, AssetNameSupplier> _registryMap = Collections.synchronizedMap(new ConcurrentHashMap<>());

    @Override
    public synchronized <T extends Object & Cloneable & AssetNameSupplier> void register(T toRegister) {
        _registryMap.put(toRegister.getClass(), toRegister);
    }

    @Override
    public synchronized <T extends AssetNameSupplier> T getSupplier(Class<T> clazz) {
        return clazz.cast(_registryMap.get(clazz));
    }

}
