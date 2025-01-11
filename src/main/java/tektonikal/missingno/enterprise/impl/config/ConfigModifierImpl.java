package tektonikal.missingno.enterprise.impl.config;

import tektonikal.missingno.Config;
import tektonikal.missingno.enterprise.pub.asset.AssetsPictureReader;
import tektonikal.missingno.enterprise.pub.config.ConfigModifier;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

public class ConfigModifierImpl implements ConfigModifier {

    protected transient volatile String _configPicture;
    protected transient volatile AssetsPictureReader _assetsPictureReader;

    public ConfigModifierImpl(AssetsPictureReader assetsPictureReader) {
        this._assetsPictureReader = assetsPictureReader;
    }

    @Override
    public void pushConfigPicturePath(String configPicture) {
        _configPicture = configPicture;
    }

    @Override
    public void writeConfigPicture() {
        try (FileOutputStream _fileOutputStream = new FileOutputStream(
                Paths.get(
                        Config.texture = _configPicture
                ).toFile()
        )) {
            _fileOutputStream.write(_assetsPictureReader.getPictureFromAsset());
        } catch (Exception e) {// TODO: Enterprise level project wide Exception and Throwable handling
        }
    }

}
