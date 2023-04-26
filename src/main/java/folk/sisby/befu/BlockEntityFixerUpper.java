package folk.sisby.befu;

import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class BlockEntityFixerUpper implements ModInitializer {
	public static final FakeBlock FAKE_BLOCK = new FakeBlock(QuiltBlockSettings.of(Material.AIR));

	public static final BlockEntityType<FakeBlockEntity> FAKE_BLOCK_ENTITY = Registry.register(
		Registry.BLOCK_ENTITY_TYPE,
		new Identifier("snowrealmagic", "snow"),
		QuiltBlockEntityTypeBuilder.create(FakeBlockEntity::new, FAKE_BLOCK).build()
	);

	public static final BlockEntityType<FakeBlockEntity> FAKE_BLOCK_ENTITY_2 = Registry.register(
		Registry.BLOCK_ENTITY_TYPE,
		new Identifier("snowrealmagic", "texture_tile"),
		QuiltBlockEntityTypeBuilder.create(FakeBlockEntity::new, FAKE_BLOCK).build()
	);

	@Override
	public void onInitialize(ModContainer mod) {
		Registry.register(Registry.BLOCK, new Identifier("snowrealmagic", "snow"), FAKE_BLOCK);
	}
}
