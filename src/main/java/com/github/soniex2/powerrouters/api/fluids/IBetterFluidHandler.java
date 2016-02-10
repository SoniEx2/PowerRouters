package com.github.soniex2.powerrouters.api.fluids;

import net.minecraftforge.fluids.*;

/**
 * Implement this interface on TileEntities which should handle fluids, generally storing them in
 * one or more internal {@link IFluidTank} objects.
 *
 * A reference implementation is provided {@link TileBetterFluidHandler}.
 *
 * @author KingLemming
 * @author soniex2
 */
public interface IBetterFluidHandler extends IFluidHandler {
    /**
     * Fills fluid into internal tanks, distribution is left entirely to the IFluidHandler.
     *
     * @param resource FluidStack representing the Fluid and maximum amount of fluid to be filled.
     * @param doFill   If false, fill will only be simulated.
     * @return Amount of resource that was (or would have been, if simulated) filled.
     */
    int fillUnknown(FluidStack resource, boolean doFill);

    /**
     * Drains fluid out of internal tanks, distribution is left entirely to the IFluidHandler.
     *
     * @param resource FluidStack representing the Fluid and maximum amount of fluid to be drained.
     * @param doDrain  If false, drain will only be simulated.
     * @return FluidStack representing the Fluid and amount that was (or would have been, if
     * simulated) drained.
     */
    FluidStack drainUnknown(FluidStack resource, boolean doDrain);

    /**
     * Drains fluid out of internal tanks, distribution is left entirely to the IFluidHandler.
     * This method is not Fluid-sensitive.
     *
     * @param maxDrain Maximum amount of fluid to drain.
     * @param doDrain  If false, drain will only be simulated.
     * @return FluidStack representing the Fluid and amount that was (or would have been, if
     * simulated) drained.
     */
    FluidStack drainUnknown(int maxDrain, boolean doDrain);

    /**
     * Returns true if the given fluid can be inserted into an unknown direction.
     * More formally, this should return true if fluid is able to enter from an unknown direction.
     */
    boolean canFillUnknown(Fluid fluid);

    /**
     * Returns true if the given fluid can be extracted from an unknown direction.
     * More formally, this should return true if fluid is able to leave from an unknown direction.
     */
    boolean canDrainUnknown(Fluid fluid);

    /**
     * Returns an array of objects which represent the internal tanks. These objects cannot be used
     * to manipulate the internal tanks. See {@link FluidTankInfo}.
     *
     * @return Info for the relevant internal tanks.
     */
    FluidTankInfo[] getTankInfoUnknown();
}
