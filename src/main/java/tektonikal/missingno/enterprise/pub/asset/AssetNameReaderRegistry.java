package tektonikal.missingno.enterprise.pub.asset;

import tektonikal.missingno.enterprise.impl.asset.AssetNameReaderRegistryImpl;

public interface AssetNameReaderRegistry {

    <T extends Object & Cloneable & AssetNameSupplier> void register(T toRegister);

    <T extends AssetNameSupplier> T getSupplier(Class<T> clazz);

    static AssetNameReaderRegistry getInstance() {
        return AssetNameReaderRegistryImpl.instance;
    }

}
