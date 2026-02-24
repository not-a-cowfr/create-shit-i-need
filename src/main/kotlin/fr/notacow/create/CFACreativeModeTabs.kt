package fr.notacow.create

import com.zurrtum.create.AllItems
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.ItemStack


object CFACreativeModeTabs {
    val GROUP: ResourceKey<CreativeModeTab> = ResourceKey.create(
        Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(
        CreateFlyAddons.MOD_ID, "base"))

    private fun register() {
        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            GROUP,
            FabricItemGroup.builder().title(Component.translatable("itemGroup.create-fly-addons"))
                .icon { ItemStack(AllItems.EXP_NUGGET) }
                .displayItems { _: ItemDisplayParameters, entries: CreativeModeTab.Output ->
                    base(
                        // displayContext,
                        entries
                    )
                }.build()
        )
    }

    fun initialize() {
        register()
    }

    private fun base(/*displayContext: ItemDisplayParameters,*/ entries: CreativeModeTab.Output) {
        entries.accept { CFAItems.GOLDEN_TICKET_CHOCOLATE_BAR }
    }
}