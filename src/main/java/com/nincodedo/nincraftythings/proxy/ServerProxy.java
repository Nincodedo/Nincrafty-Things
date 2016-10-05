package com.nincodedo.nincraftythings.proxy;

public class ServerProxy extends CommonProxy {

	@Override
	public ClientProxy getClientProxy() {
		return null;
	}

	@Override
	public void spawnParticle(String particleName, double xCoord, double yCoord, double zCoord, double xVelocity,
			double yVelocity, double zVelocity) {

	}

}
