package fr.notacow.create

import com.zurrtum.create.Create
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object CreateFlyAddons : ModInitializer {
	const val MOD_ID: String = "create-fly-addons"
	const val NAME: String = "Create Fly Addons"
	val logger = LoggerFactory.getLogger(MOD_ID)!!

	override fun onInitialize() {
		logger.info("Create addon mod $NAME loading alongside Create version ${Create.VERSION}")

		CFAItems.initialize()
		CFACreativeModeTabs.initialize()
	}
}