# To change this template, choose Tools | Templates
# and open the template in the editor.

require 'java'


module Yargui
  class Color < java.awt.Color
  end

  class Dimension < java.awt.Dimension

  end

  class BufferedImage < java.awt.image::BufferedImage
  end

  class GradientPaint < java.awt::GradientPaint
   
  end


  class GridEdit < javax.swing.JComponent

    UI_CLASS_ID = "GridEditUI";

    attr_reader :wide
    attr_reader :high

    def initialize(gridmodel)
      super()

      @factor = 20    # magrnification factor
      @lines  = true # draw the grid lines or not?
      @color  = Color.new(255,255,255)
      # Color to draw the grid with
      @back1  = Color.new(0,0,0)
      @back2  = Color.new(127,127,127)
      # Background colors of grid
      self.setBackground(@back)
      self.grid = gridmodel
    end

    def draw_buffered()
      g  = @buffer.createGraphics()
      paint_background(g)
      paint_grid(g)
      g.dispose()
    end

    def grid=(grid)
      @grid   = grid # the grid we're editing
      @wide   = @grid.wide * @factor
      @high   = @grid.high * @factor
      @dim    = Dimension.new(@wide + 1, @high + 1)
      self.setMinimumSize(@dim)
      self.setSize(@dim)
      self.setMaximumSize(@dim )
      @buffer = BufferedImage.new(800, 600, BufferedImage::TYPE_INT_RGB)
      draw_buffered()
    end

    def paintComponent(g)
       puts "draw called"
       super(g)
       g.drawImage(@buffer, 0, 0, nil);
       # paint_background(g)
       # self.paint_grid(g)
    end

    def paint_background(g)
      g.setPaint(@back1)
      g.fillRect(0, 0, @wide, @high)
    end

    def paint_grid(g)
      g.setPaint(@color)
      for i in (1..@grid.wide)
        x =  i * @factor
        g.drawLine(x , 0, x, @high)
      end

      for j in (1..@grid.high)
        y =  j * @factor
        g.drawLine(0, y, @wide, y)
      end
    end

=begin

    def getUIClassID()
      return UI_CLASS_ID
    end
=end

  end
end
