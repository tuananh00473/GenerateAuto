USE [vkmkdido_candimex]
GO
/****** Object:  Table [dbo].[Article]    Script Date: 08/23/2013 23:44:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Article] (
  [Id]        [int] IDENTITY (1, 1) NOT NULL,
  [Title]     [nvarchar](MAX)       NOT NULL,
  [Content]   [nvarchar](MAX)       NOT NULL,
  [Type]      [int]                 NOT NULL,
  [Active]    [int]                 NOT NULL,
  [Thumbnail] [nvarchar](MAX)       NOT NULL,
  [Address]   [int]                 NOT NULL,
  CONSTRAINT [PK_Article] PRIMARY KEY CLUSTERED
    (
      [Id] ASC
    )
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
    ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Support]    Script Date: 08/23/2013 23:44:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Support] (
  [Id]     [int] IDENTITY (1, 1) NOT NULL,
  [Type]   [int]                 NOT NULL,
  [Name]   [nvarchar](MAX)       NOT NULL,
  [Phone]  [nvarchar](MAX)       NOT NULL,
  [Email]  [nvarchar](MAX)       NOT NULL,
  [Value]  [nvarchar](MAX)       NOT NULL,
  [Active] [int]                 NOT NULL,
  CONSTRAINT [PK_Support] PRIMARY KEY CLUSTERED
    (
      [Id] ASC
    )
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
    ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Statistic]    Script Date: 08/23/2013 23:44:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Statistic] (
  [Id]     [int] IDENTITY (1, 1) NOT NULL,
  [Date]   [nvarchar](MAX)       NOT NULL,
  [Amount] [bigint]              NOT NULL,
  CONSTRAINT [PK_Statistic] PRIMARY KEY CLUSTERED
    (
      [Id] ASC
    )
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
    ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FeedBack]    Script Date: 08/23/2013 23:44:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeedBack] (
  [Id]      [int] IDENTITY (1, 1) NOT NULL,
  [Name]    [nvarchar](MAX)       NOT NULL,
  [Email]   [nvarchar](MAX)       NOT NULL,
  [Phone]   [nvarchar](MAX)       NOT NULL,
  [Title]   [nvarchar](MAX)       NOT NULL,
  [Content] [nvarchar](MAX)       NOT NULL,
  [Status]  [int]                 NOT NULL,
  CONSTRAINT [PK_FeedBack] PRIMARY KEY CLUSTERED
    (
      [Id] ASC
    )
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
    ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PriceList]    Script Date: 08/23/2013 23:44:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PriceList] (
  [Id]            [int] IDENTITY (1, 1) NOT NULL,
  [Address]       [int]                 NOT NULL,
  [Title]         [nvarchar](MAX)       NOT NULL,
  [LinkGoogleDoc] [nvarchar](MAX)       NOT NULL,
  [LinkPDF]       [nvarchar](MAX)       NOT NULL,
  [LinkWord]      [nvarchar](MAX)       NOT NULL,
  [LinkImage]     [nvarchar](MAX)       NOT NULL,
  [Active]        [int]                 NOT NULL,
  CONSTRAINT [PK_PriceList] PRIMARY KEY CLUSTERED
    (
      [Id] ASC
    )
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
    ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Partner]    Script Date: 08/23/2013 23:44:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Partner] (
  [Id]          [int] IDENTITY (1, 1) NOT NULL,
  [Name]        [nvarchar](MAX)       NOT NULL,
  [Link]        [nvarchar](MAX)       NOT NULL,
  [Logo]        [nvarchar](MAX)       NOT NULL,
  [Description] [nvarchar](MAX)       NOT NULL,
  [Active]      [int]                 NOT NULL,
  CONSTRAINT [PK_Partner] PRIMARY KEY CLUSTERED
    (
      [Id] ASC
    )
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
    ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 08/23/2013 23:44:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill] (
  [Id]           [int] IDENTITY (1, 1) NOT NULL,
  [SerialNumber] [nvarchar](MAX)       NOT NULL,
  [Type]         [nvarchar](MAX)       NOT NULL,
  [SendFrom]     [nvarchar](MAX)       NOT NULL,
  [SendDate]     [nvarchar](MAX)       NOT NULL,
  [SendTo]       [nvarchar](MAX)       NOT NULL,
  [Service]      [nvarchar](MAX)       NOT NULL,
  [Status]       [int]                 NOT NULL,
  CONSTRAINT [PK_Bill] PRIMARY KEY CLUSTERED
    (
      [Id] ASC
    )
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
    ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BillDetail]    Script Date: 08/23/2013 23:44:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillDetail] (
  [Id]     [int] IDENTITY (1, 1) NOT NULL,
  [BillId] [int]                 NOT NULL,
  [Date]   [nvarchar](MAX)       NOT NULL,
  [Detail] [nvarchar](MAX)       NOT NULL,
  CONSTRAINT [PK_BillDetail] PRIMARY KEY CLUSTERED
    (
      [Id] ASC
    )
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
    ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 08/23/2013 23:44:30 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account] (
  [Id]       [int] IDENTITY (1, 1) NOT NULL,
  [UserName] [nvarchar](MAX)       NOT NULL,
  [Password] [nvarchar](MAX)       NOT NULL,
  [FullName] [nvarchar](MAX)       NULL,
  [Address]  [nvarchar](MAX)       NULL,
  [Mobile]   [nvarchar](MAX)       NULL,
  [Role]     [int]                 NOT NULL,
  [Active]   [int]                 NOT NULL,
  CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED
    (
      [Id] ASC
    )
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
    ON [PRIMARY]
) ON [PRIMARY]
GO