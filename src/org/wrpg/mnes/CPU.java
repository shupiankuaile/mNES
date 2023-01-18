package org.wrpg.mnes;

/**
 *
 * https://www.nesdev.org/wiki/CPU_memory_map
 * https://www.nesdev.org/nestech_cn.txt
 *
 *
 * NROM:
 * https://www.nesdev.org/wiki/NROM
 * https://www.nesdev.org/wiki/Programming_NROM
 *
 *     +---------+-------+-------+-----------------------+
 *     | 地址    | 大小  | 标记  |         描述          |
 *     +---------+-------+-------+-----------------------+
 *     | $0000   | $800  |       | RAM                   |
 *     | $0800   | $800  | M     | RAM                   |
 *     | $1000   | $800  | M     | RAM                   |
 *     | $1800   | $800  | M     | RAM                   |
 *     | $2000   | 8     |       | Registers             |
 *     | $2008   | $1FF8 |  R    | Registers             |
 *     | $4000   | $20   |       | Registers             |
 *     | $4020   | $1FDF |       | Expansion ROM         |
 *     | $6000   | $2000 |       | SRAM                  |
 *     | $8000   | $4000 |       | PRG-ROM               |
 *     | $C000   | $4000 |       | PRG-ROM               |
 *     +---------+-------+-------+-----------------------+
 *            标记图例: M = $0000的镜像
 *                         R = $2000-2008 每 8 bytes 的镜像
 *                             (e.g. $2008=$2000, $2018=$2000, etc.)
 */
public class CPU {

    private static final int RAM_SIZE = 2*1024;//byte
    private static final int RAM_ZERO_PAGE = 256;//byte
    private static final int RAM_STACK = 256;//byte
    private static final int RAM_OTHER = RAM_SIZE - RAM_ZERO_PAGE - RAM_STACK;//byte

    private static final int IO_REGISTERS_1_SIZE = 8;//byte
    private static final int IO_REGISTERS_2_SIZE = 32;//byte


    private byte[] ram = new byte[RAM_SIZE];//$0000-$0800
    private byte[] mirror1 = new byte[RAM_SIZE];
    private byte[] mirror2 = new byte[RAM_SIZE];
    private byte[] mirror3 = new byte[RAM_SIZE];

    private byte[] ioRegisters1 = new byte[IO_REGISTERS_1_SIZE];//$2000-2008
    private byte[] ioRegisters2 = new byte[IO_REGISTERS_2_SIZE];//$4000-$4020

    Cartridge cartridge;

    public CPU(Cartridge cartridge) {
        this.cartridge = cartridge;
    }
}
