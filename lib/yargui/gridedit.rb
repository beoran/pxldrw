# To change this template, choose Tools | Templates
# and open the template in the editor.

require 'java'


module Yargui
  class Color < Awt::Color
  end

  class Dimension < Awt::Dimension

  end

  class BufferedImage < Awt::Image::BufferedImage
  end

  class GradientPaint < Awt::GradientPaint
  end

  
  class Gridedit < Swing::JComponent

    include Mouse::Adapter
    include Action::Adapter

    UI_CLASS_ID = "GridEditUI";

    attr_reader   :wide
    attr_reader   :high
    attr_reader   :zoom
    attr_accessor :lines



    # Initializes the Gird editor with a grid model.
    def initialize(gridmodel, zoom=20)
      super()
      @zoom   = zoom   # Zoom factor
      @lines  = true # draw the grid lines or not?
      @color  = Color.new(255,255,255)
      # Color to draw the grid with
      @back1  = Color.new(64,64,64)
      @back2  = Color.new(127,127,127)
      # Background colors of grid
      self.setBackground(@back)
      self.grid = gridmodel
    end

    # Draws self to the bitmap backbuffer
    def draw_buffered()
      g  = @buffer.createGraphics()
      paint_background(g)
      paint_grid(g)
      g.dispose()
    end

    # Changes the grid model assoicated with this editor
    def grid=(grid)
      @grid   = grid # the grid we're editing
      if @grid
        update
      end
    end
    
    # Changes the zoom factor for this grid editor
    def zoom=(zoom)
      @zoom = zoom
      update
    end

    # Called when the grid or the zoom changes
    def update
      @wide   = @grid.wide * @zoom
      @high   = @grid.high * @zoom
      @dim    = Dimension.new(@wide, @high)
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

    # Paints the background color
    def paint_background(g)
      g.setPaint(@back1)
      g.fillRect(0, 0, @wide, @high)
    end

    # Paints the grid's contents if it's not nil
    def paint_grid(g)
      y = 0
      for ydex in 0...@high
        x = 0
        for xdex in 0...@wide
          pixel = @grid.get(xdex, ydex)
          if pixel && pixel.opaque?
            color = Color.new(*pixel)
            g.setPaint(color)
            g.fillRect(x, y , @zoom, @zoom)
          else # Invisible or empty pixels. Indicate them with a gradient.
            @grad = GradientPaint.new(x , y, @back1, x + @zoom, y  + @zoom, @back2)
            g.setPaint(@grad)
            g.fillRect(x, y, @zoom, @zoom)
          end
          if @lines # draw the grid outlines if needed
            g.setPaint(@color)
            g.drawRect(x, y , @zoom, @zoom)
          x += @zoom
          end
          y += @zoom
        end
      end
    end

    def getUIClassID()
      return UI_CLASS_ID
    end


  end
end
