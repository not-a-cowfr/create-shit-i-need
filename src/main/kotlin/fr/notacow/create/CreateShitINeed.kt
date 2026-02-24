package fr.notacow.create

import com.zurrtum.create.Create
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object CreateShitINeed : ModInitializer {
	const val MOD_ID: String = "create-shit-i-need"
	const val NAME: String = "Create: SIN"
	val logger = LoggerFactory.getLogger(MOD_ID)!!

	override fun onInitialize() {
		logger.info("Create addon mod $NAME loading alongside Create version ${Create.VERSION}")
		ModItems.initialize()
		ModCreativeModeTabs.initialize()
	}
}