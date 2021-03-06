package com.vvftc.ninevolt.core.hw;

import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by VVMS FTC teams on 2/23/2017.
 */

public class HardwareBuilder {

  private HardwareMap hardwareMap;
  private Hardware building;
  private boolean motorAllowed = false;

  /* TODO: Frame and write HardwareBuilder class using Builder design pattern
     Read here: https://sourcemaking.com/design_patterns/builder */
  public HardwareBuilder(HardwareMap hardwareMap) {
    this.hardwareMap = hardwareMap;
    building = new Hardware();
  }

  public HardwareBuilder setMotorConfig(Hardware.MotorMode motorMode,
                                        Hardware.MotorType motorType) {
    building.setMotorMode(motorMode);
    building.setMotorType(motorType);
    motorAllowed = true;
    return this;
  }

  public HardwareBuilder addMotorFL(String hwMapName) throws Exception {
    if (!motorAllowed) { throw new Exception("Must configure motors before adding any!"); }
    building.setMotorFL(hardwareMap.dcMotor.get(hwMapName));
    return this;
  }
  public HardwareBuilder addMotorFR(String hwMapName) throws Exception {
    if (!motorAllowed) { throw new Exception("Must configure motors before adding any!"); }
    building.setMotorFR(hardwareMap.dcMotor.get(hwMapName));
    return this;
  }
  public HardwareBuilder addMotorBL(String hwMapName) throws Exception {
    if (!motorAllowed) { throw new Exception("Must configure motors before adding any!"); }
    building.setMotorBL(hardwareMap.dcMotor.get(hwMapName));
    return this;
  }
  public HardwareBuilder addMotorBR(String hwMapName) throws Exception{
    if (!motorAllowed) { throw new Exception("Must configure motors before adding any!"); }
    building.setMotorBR(hardwareMap.dcMotor.get(hwMapName));
    return this;
  }

  public Hardware build() {
    return building;
  }
}
