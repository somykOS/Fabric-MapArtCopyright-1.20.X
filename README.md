# Map art Copyright
A small server side mod designed to note the author who created the map. Allows to disable map copying.
***
Default config values:
```yaml
# Adds NBT 'authors' when creating a new filled map
copyright: true

# Works if 'copyright' is/was 'true'. Up to 5 players can be displayed in a map lore
displayAuthorsLore: true

# Nobody can make a copy of a map (except authors if 'authorsCanCopy' is 'true')
disableCopy: false

# Works if 'copyright' is/was 'true'
authorsCanCopy: true

# Authors can use `/mapAuthor add <player>` command
authorsCanAddAuthors: true

# Allows to clean a map with a bucket of water in a cartography table
cleanMap: false
```

You can manage config in-game with the command `/mapartcopyright <config-value> true/false`. <br>
To use this command you need the permission `mapartcopyright.changeconfig`. <br>
This mod uses [fabric-permission-api](https://github.com/lucko/fabric-permissions-api/). <br>
(Alternatively, you can change it manually in `config/MapArtCopyright/config.yml`)

To use `/mapAuthor add <player>` you should be one of the map authors or have `mapartcopyright.addauthor` permission. <br>
To use `/mapAuthor remove <player>` you should have `mapartcopyright.removeauthor` permission.

As you can see, you can also disable map copying so nobody can copy it (except authors if `authorsCanCopy` is `true`). <br>
I've also added the ability to clean a map with a bucket of water on a cartography table. It won't work if `cleanMap` is `false`.

***
It's my very first mod. Special thanks for hints to LlamaLad7, [Zefir](https://modrinth.com/user/Stikulzon) and [Bawnorton](https://modrinth.com/user/Bawnorton). <br>
If there is any issue, please visit [GitHub source](https://github.com/somykOS/Fabric-MapArtCopyright-1.20.X/tree/1.20.1) and open one. <br>
Mod **sources** for different MC versions are located **in branches**. Main branch has README only. <br>
If you need this mod for another MC version, you can open a new discussion on the previously mentioned GitHub page.