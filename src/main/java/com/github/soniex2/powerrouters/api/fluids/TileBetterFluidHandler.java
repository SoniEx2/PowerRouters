package com.github.soniex2.powerrouters.api.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.TileFluidHandler;

/**
 * Reference Tile Entity implementation of {@link IBetterFluidHandler}. Use/extend this or write your own.
 *
 * @author King Lemming
 * @author soniex2
 */
public class TileBetterFluidHandler extends TileFluidHandler implements IBetterFluidHandler {
    @Override
    public int fillUnknown(FluidStack resource, boolean doFill) {
        return tank.fill(resource, doFill);
    }

    @Override
    public FluidStack drainUnknown(FluidStack resource, boolean doDrain) {
        if (resource == null || !resource.isFluidEqual(tank.getFluid())) return null;
        return tank.drain(resource.amount, doDrain);
    }

    @Override
    public FluidStack drainUnknown(int maxDrain, boolean doDrain) {
        return tank.drain(maxDrain, doDrain);
    }

    @Override
    public boolean canFillUnknown(Fluid fluid) {
        return true;
    }

    @Override
    public boolean canDrainUnknown(Fluid fluid) {
        return true;
    }

    @Override
    public FluidTankInfo[] getTankInfoUnknown() {
        return new FluidTankInfo[] {tank.getInfo()};
    }
}
