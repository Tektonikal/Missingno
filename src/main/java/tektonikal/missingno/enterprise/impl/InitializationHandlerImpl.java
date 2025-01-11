package tektonikal.missingno.enterprise.impl;

import net.fabricmc.loader.impl.FabricLoaderImpl;
import tektonikal.missingno.Config;
import tektonikal.missingno.enterprise.impl.asset.AssetNameReaderImpl;
import tektonikal.missingno.enterprise.impl.asset.AssetsPictureReaderImpl;
import tektonikal.missingno.enterprise.impl.config.ConfigModifierImpl;
import tektonikal.missingno.enterprise.pub.ConditionalRunnable;
import tektonikal.missingno.enterprise.pub.InitializationHandler;
import tektonikal.missingno.enterprise.pub.asset.AssetNameReaderRegistry;
import tektonikal.missingno.enterprise.pub.asset.AssetNameSupplier;
import tektonikal.missingno.enterprise.pub.asset.AssetsPictureReader;
import tektonikal.missingno.enterprise.pub.config.ConfigModifier;

public class InitializationHandlerImpl implements InitializationHandler {

    @Override
    public void handleInit() {
        ConditionalRunnable.check(Config.texture.isBlank(), () -> {
            AssetsPictureReader _assetsPictureReader = new AssetsPictureReaderImpl();
            AssetNameSupplier _supplier = AssetNameReaderRegistry.getInstance().getSupplier(AssetNameReaderImpl.class);
            _assetsPictureReader.pushPictureFromAssets(_supplier);
            ConfigModifier modifier = new ConfigModifierImpl(_assetsPictureReader);
            modifier.pushConfigPicturePath(
                    FabricLoaderImpl.INSTANCE.getConfigDir().resolve("missingno").resolve("default.png").toString()
            );
            modifier.writeConfigPicture();
        });
    }

}
