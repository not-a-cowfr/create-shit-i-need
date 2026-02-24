package fr.notacow.create

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item


object CFAItems {
    val GOLDEN_TICKET_CHOCOLATE_BAR: Item = register(
        name = "golden_ticket_chocolate_bar",
        properties = Item.Properties().food(
            FoodProperties.Builder()
                .nutrition(6)
                .saturationModifier(18f)
                .build()
        )
    )

    private fun register(
        name: String,
        itemFactory: (Item.Properties) -> Item = ::Item,
        properties: Item.Properties = Item.Properties()
    ): Item {
        val key = ResourceKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath(CreateFlyAddons.MOD_ID, name)
        )
        return itemFactory(properties.setId(key))
            .also { Registry.register(BuiltInRegistries.ITEM, key, it) }
    }

    fun initialize() {}
}